package com.carss.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping("/payamount")
	private void pay(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
		
		String rid=request.getParameter("rid");
		String returntime=request.getParameter("returntime");
		
		System.out.println(rid);
		
		
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
		// 页面跳转同步通知页面路径
		alipayRequest.setReturnUrl("http://localhost:8080/bikesharing/ispay.html?rid="+rid+"&amount="+total_amount+"&returntime="+returntime);
		// 服务器异步通知页面路径
		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		/*System.out.println("{\"out_trade_no\":\""+ WIDout_trade_no +"\"," 
				+ "\"total_amount\":\""+ WIDtotal_amount +"\"," 
				+ "\"subject\":\""+ WIDsubject +"\"," 
				+ "\"body\":\""+ WIDbody +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");*/
		
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
}
