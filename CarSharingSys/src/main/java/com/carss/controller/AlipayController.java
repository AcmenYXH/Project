package com.carss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.carss.entity.*;
import com.carss.service.DepositinfoService;
import com.carss.service.RentinfoService;
import com.carss.service.UserinfoService;
import com.carss.utils.OrderUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
/**
 * 支付宝控制模块
 * **/
@Controller
public class AlipayController {
    @Autowired
    private RentinfoService rentinfoService;
    @Autowired
    private DepositinfoService depositinfoService;
    @Autowired
    private UserinfoService userinfoService;
    @Resource
	private RedisTemplate<String,Object> redisTemplate;

	private static final Logger logger = LoggerFactory.getLogger(AlipayController.class);

	@RequestMapping("/payamount")
	private void pay(HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		String rid = request.getParameter("rid");
		request.getSession().setAttribute("temp_rid",rid);
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = request.getParameter("WIDout_trade_no");

		//获取请支付的页面
		if ("true".equals(request.getParameter("isdeposit2"))){
			if(!selectDepositInfoStatus(alipayClient, Integer.parseInt(rid))){
				String orderid = OrderUtils.getTradeId();
				paymentPage(alipayClient,true,request,response);
			}else{
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				out.println("<script>" +
						"alert(\"押金已缴纳，请刷新页面！\");" +
						"location.href=\"depositinfo.html\";" +
						"</script>");
				out.flush();
				out.close();
			}
		}else if (!alipayTradeQuery(alipayClient,out_trade_no,rid)){
			paymentPage(alipayClient,false,request,response);
		}else {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<script>" +
					"alert(\"该订单已完成支付，请刷新页面！\");" +
					"location.href=\"userrentinfo.html\";" +
					"</script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * 支付页面
	 * @param alipayClient
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void paymentPage(AlipayClient alipayClient,boolean isDeposit,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//商家订单号
		String out_trade_no = "";
		if (isDeposit == true) {
			out_trade_no = OrderUtils.getTradeId();
			//保存商家号
			redisTemplate.opsForValue().set("out_trade_no", out_trade_no, 30,TimeUnit.MINUTES);
		}else{
			out_trade_no = request.getParameter("WIDout_trade_no");
		}

		//付款金额，必填
		String total_amount = request.getParameter("WIDtotal_amount");
		//订单名称，必填
		String subject = request.getParameter("WIDsubject");
		//商品描述，可空
		String body = request.getParameter("WIDbody");
		//设置快速交易请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		// 服务器异步通知页面路径
		//alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		// 页面跳转同步通知页面路径
		alipayRequest.setReturnUrl(AlipayConfig.return_url);

		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
				+ "\"total_amount\":\""+ total_amount +"\","
				+ "\"subject\":\""+ subject +"\","
				+ "\"body\":\""+ body +"\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String result="";
		try {
			result = alipayClient.pageExecute(alipayRequest).getBody();
			System.out.println("支付返回结果："+result);
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <BODY>");
		out.println(result);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * 通过商家订单号查询订单的交易状态，若为交易成功状态，则修改数据库订单状态为已支付
	 * @param alipayClient
	 * @param out_trade_no
	 * @param rid
	 * @return
	 * @throws AlipayApiException
	 */
	public Boolean alipayTradeQuery(AlipayClient alipayClient,String out_trade_no,String rid) throws AlipayApiException {
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
		alipayRequest.setBizContent("{" +
				"\"out_trade_no\":\""+ out_trade_no +"\"," +
				"      \"query_options\":[" +
				"        \"TRADE_SETTLE_INFO\"" +
				"      ]" +
				"  }");
		AlipayTradeQueryResponse response = alipayClient.execute(alipayRequest);
		if(response.isSuccess()){
			if ("TRADE_SUCCESS".equals(response.getTradeStatus())){
				Rentinfo rentinfo = new Rentinfo();
				System.out.println("rid:"+rid);
				rentinfo.setRentid(Integer.parseInt(rid));
				rentinfo.setIsplay("已支付");
				System.out.println("对象："+JSONObject.fromObject(rentinfo).toString());
				boolean result = rentinfoService.editRentinfo(rentinfo);

				return true;
			}else{
				return false;
			}
		} else {
			System.out.println("调用失败");
			return false;
		}
	}

	/**
	 * 查询押金是否已经缴纳
	 * @param alipayClient
	 * @param userid
	 * @return
	 * @throws AlipayApiException
	 */
	public Boolean selectDepositInfoStatus(AlipayClient alipayClient,int userid) throws AlipayApiException {
		redisTemplate.opsForValue().set("userid", userid,30 ,TimeUnit.MINUTES);
		Depositinfo depositinfo = new Depositinfo();
		depositinfo.setUserid(userid);
		DepositinfoExample depositinfoExample = new DepositinfoExample();
		depositinfoExample.createCriteria().andUseridEqualTo(userid);
		List<Depositinfo> depositinfoList = depositinfoService.getDepositinfo(depositinfoExample);
		//判断是否存在用户押金信息
		if (depositinfoList.size()>0){
			Depositinfo depositinfo1 = depositinfoList.get(0);
			if ("001".equals(depositinfo1)){
				String out_trade_no = "";
				if (redisTemplate.hasKey("out_trade_no")){
					out_trade_no = redisTemplate.opsForValue().get("out_trade_no").toString();
				}else{
					out_trade_no = depositinfo1.getOutTradeNo();
				}
				AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
				alipayRequest.setBizContent("{" +
						"\"out_trade_no\":\""+ out_trade_no +"\"," +
						"      \"query_options\":[" +
						"        \"TRADE_SETTLE_INFO\"" +
						"      ]" +
						"  }");
				AlipayTradeQueryResponse response = alipayClient.execute(alipayRequest);
				if(response.isSuccess()){
					if ("TRADE_SUCCESS".equals(response.getTradeStatus())){
					    //修改押金信息
						depositinfo = depositinfoList.get(0);
						depositinfo.setDepositStatus("001");
						depositinfo.setChangeTime(new Date());
						depositinfoService.editDepositinfo(depositinfo,depositinfoExample);
						//修改用户信息
                        UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
                        userinfo.setUserid(depositinfoList.get(0).getUserid());
                        userinfo.setIsdeposit("已缴纳");
                        userinfoService.editUserinfo(userinfo);
						return true;
					}else{
						return false;
					}
				} else {
					System.out.println("调用失败");
					return false;
				}
			}else {
				return false;
			}
		}else {
			depositinfo.setOutTradeNo(OrderUtils.getTradeId());
			depositinfo.setChangeTime(new Date());
			depositinfo.setDepositStatus("000");
			depositinfoService.addDepositinfo(depositinfo);
			return false;
		}
	}


	/**
	 ** 功能：支付宝服务器同步通知页面
	 *  * 日期：2017-03-30
	 *  * 说明：
	 *  * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *  * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	 * @param request
	 * @param response
	 */
	@GetMapping("pay/returnUrl")
	public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("======同步通知页面======");
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		System.out.println("同步通知---验证签名：");
		System.out.println(params);
		boolean signVerified = false;
		//调用SDK验证签名
		signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
			//String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

				RentinfoExample rentinfoExample = new RentinfoExample();
				rentinfoExample.createCriteria().andTradeNoEqualTo(out_trade_no);
				List<Rentinfo> rentinfoList = rentinfoService.findSimpleRentinfoByExample(rentinfoExample);
				if (rentinfoList.size() > 0){
					Rentinfo rentinfo = rentinfoList.get(0);
					BigDecimal alipayAmount = new BigDecimal(total_amount);
					BigDecimal amount = new BigDecimal(rentinfo.getAmount());
					if (logger.isInfoEnabled()){
						logger.info("total_amount:{}=======amount:{}",total_amount,rentinfo.getAmount());
						logger.info("alipayAmount:{}=======amount:{}",alipayAmount,amount);
					}
					if (alipayAmount.compareTo(amount) == 0){
						rentinfo.setIsplay("已支付");
						rentinfoService.editRentinfo(rentinfo);
						return "redirect:/userrentinfo.html";
					}
				}else{
				    //修改押金表信息
					Depositinfo depositinfo = new Depositinfo();
					depositinfo.setOutTradeNo(out_trade_no);
					depositinfo.setAmount(Double.parseDouble(total_amount));
					depositinfo.setChangeTime(new Date());
					depositinfo.setTradeNo(trade_no);
					depositinfo.setDepositStatus("001");
					DepositinfoExample depositinfoExample = new DepositinfoExample();
					Integer userid = (Integer) redisTemplate.opsForValue().get("userid");
					depositinfoExample.createCriteria().andUseridEqualTo(userid);
					depositinfoService.editDepositinfo(depositinfo,depositinfoExample);
					//查询押金信息
                    depositinfoExample.clear();
                    depositinfoExample.createCriteria().andOutTradeNoEqualTo(out_trade_no).andDepositStatusEqualTo("001");
                    List<Depositinfo> depositinfoList = depositinfoService.getDepositinfo(depositinfoExample);
					//修改用户表信息
                    UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
                    userinfo.setUserid(depositinfoList.get(0).getUserid());
                    userinfo.setIsdeposit("已缴纳");
                    userinfoService.editUserinfo(userinfo);
					return "redirect:/depositinfo.html";
				}


		}else {
			if (logger.isInfoEnabled()){
				logger.info("同步==验签失败");
			}
		}
		return "redirect:/userrentinfo.html";
	}

	/**
	 * 功能：支付宝服务器异步通知页面
	 *  * 日期：2017-03-30
	 *  * 说明：
	 *  * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *  * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	 *
	 *
	 *  *************************页面功能说明*************************
	 *  * 创建该页面文件时，请留心该页面文件中无任何HTML代码及空格。
	 *  * 该页面不能在本机电脑测试，请到服务器上做测试。请确保外部可以访问该页面。
	 *  * 如果没有收到该页面返回的 success
	 *  * 建议该页面只做支付成功的业务逻辑处理，退款的处理请以调用退款查询接口的结果为准。
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping("pay/notifyUrl")
	public void notifyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("========异步通知页面=========");
		//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		System.out.println("异步通知---验证签名：");
		System.out.println(params);
		boolean signVerified = false;
		//调用SDK验证签名
		signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,AlipayConfig.sign_type);

		//——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("商户订单号："+out_trade_no+"----支付宝交易号："+trade_no);
			System.out.println("=========交易状态======："+trade_status);
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				System.out.println("交易完成====校验处理步骤！");
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				System.out.println("交易成功====校验处理步骤！");
//				String temp_rid = request.getSession().getAttribute("temp_rid").toString();
//				if (temp_rid.length() > 0){
//					Rentinfo rentinfo = new Rentinfo();
//					rentinfo.setRentid(Integer.parseInt(temp_rid));
//					rentinfo.setIsplay("已支付");
//					rentinfoService.editRentinfo(rentinfo);
//				}
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
			}

			System.out.println("success");

		}else {//验证失败
			System.out.println("异步==验签失败");

			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}

		//——请在这里编写您的程序（以上代码仅作参考）——
	}

	@GetMapping("go/homepage")
	public String goToHomepage(){
		return "redirect:/homepage";
	}
}
