package com.carss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.internal.util.AlipaySignature;
import com.carss.entity.Rentinfo;
import com.carss.service.RentinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("/payamount")
	private void pay(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		String rid=request.getParameter("rid");
		String returntime=request.getParameter("returntime");
		
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = request.getParameter("WIDout_trade_no");
		//付款金额，必填
		String total_amount = request.getParameter("WIDtotal_amount");
		//订单名称，必填
		String subject = request.getParameter("WIDsubject");
		//商品描述，可空
		String body = request.getParameter("WIDbody");
		
		//设置请求参数
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		// 服务器异步通知页面路径
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
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
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
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
	 ** 功能：支付宝服务器同步通知页面
	 *  * 日期：2017-03-30
	 *  * 说明：
	 *  * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 *  * 该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	 * @param request
	 * @param response
	 */
	@RequestMapping("pay/returnUrl")
	public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "userrentinfo";
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
				Map<String,Object> tempRentinfo = (Map<String, Object>) request.getSession().getAttribute("tempRentinfo");
				System.out.println(tempRentinfo.toString());
				if (tempRentinfo.size() > 0 ){
					Rentinfo rentinfo = new Rentinfo();
					rentinfo.setRentid((Integer) tempRentinfo.get("RENTID"));
					rentinfo.setIsplay("已支付");
					rentinfoService.editRentinfo(rentinfo);
				}

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
}
