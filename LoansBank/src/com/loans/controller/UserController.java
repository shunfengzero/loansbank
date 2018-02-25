package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.loans.config.AlipayConfig;
import com.loans.entity.Pay;
import com.loans.entity.Users;
import com.loans.message.SmsDemo;
import com.loans.service.UserService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import antlr.StringUtils;
import net.sf.json.JSONObject;

public class UserController extends ActionSupport implements ModelDriven<Users>{

	private Users user;
	private UserService userService = new UserService();
	private SmsDemo s = new SmsDemo();
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		if (user == null) {
			user = new Users();
		}
		
		return user;
	}

	public void myBankCard() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		String userName = (String)session.getAttribute("loginuser");
		user.setUserName(userName);
		JsonBean bean = new JsonBean();
		
		try {
			Users u = userService.myBankCar(user);
			bean.setCode(1);
			bean.setMsg(u);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			bean.setCode(0);
			bean.setMsg(e1.getMessage());
		}
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(bean).toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getCode() {
		
		HttpServletRequest request1 = ServletActionContext.getRequest();
		HttpServletResponse response1 = ServletActionContext.getResponse();
		HttpSession session = request1.getSession();
		
		String randomCode = request1.getParameter("randomCode");
		String telePhone = request1.getParameter("telePhone");
		//String user = (String)session.getAttribute("login");
		JsonBean bean = new JsonBean();
		  SendSmsResponse response = null;
		
			try {
				response = s.sendSms(telePhone, randomCode);

				System.out.println("短信接口返回的数据----------------");
				System.out.println("Code=" + response.getCode());
				System.out.println("Message=" + response.getMessage());
				System.out.println("RequestId=" + response.getRequestId());
				System.out.println("BizId=" + response.getBizId());

      
					Thread.sleep(3000L);


				//查明细
				if(response.getCode() != null && response.getCode().equals("OK")) {
					
				    QuerySendDetailsResponse querySendDetailsResponse = null;;
					
						querySendDetailsResponse = s.querySendDetails(response.getBizId());
					
				    System.out.println("短信明细查询接口返回数据----------------");
				    System.out.println("Code=" + querySendDetailsResponse.getCode());
				    System.out.println("Message=" + querySendDetailsResponse.getMessage());
				    int i = 0;
				    for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
				    {
				        System.out.println("SmsSendDetailDTO["+i+"]:");
				        System.out.println("Content=" + smsSendDetailDTO.getContent());
				        System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
				        System.out.println("OutId=" + smsSendDetailDTO.getOutId());
				        System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
				        System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
				        System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
				        System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
				        System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
				    }
				    System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
				    System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
				}
				
				bean.setCode(1);
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				bean.setCode(0);
				bean.setMsg(e.getMessage());
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				bean.setCode(0);
				bean.setMsg(e.getMessage());
				e.printStackTrace();
			}
	
	}
	
	//修改密码
	public void updatePassword() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String newPass = request.getParameter("newPass");
		String userName = (String)session.getAttribute("loginuser");
		user.setUserName(userName);
		Users u = userService.myBankCar(user);
		u.setPassWord(newPass);
		JsonBean bean = new JsonBean();
		try {
			userService.updatePassWord(u);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(bean).toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//充值
	public void recharge() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		String money = request.getParameter("payMoney");
		String orderNo = UUID.randomUUID().toString();
		String userName = (String)session.getAttribute("loginuser");
		//String orderNo = "test201801311455531";
		  //2.支付
        Pay p = new Pay();
        p.setOut_trade_no(orderNo);
        p.setTotal_amount(Integer.parseInt(money));
        p.setSubject(userName);
        p.setBody("");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        String json = JSON.toJSONString(p);
        alipayRequest.setBizContent(json);
        JsonBean bean = new JsonBean();
        PrintWriter writer = null;
        
       user.setUserName(userName);
       Users u = userService.myBankCar(user);
       String nMoney = u.getAccountBalance();
       if (nMoney == null || nMoney.equals("") || nMoney.isEmpty()) {
    	   nMoney = "0";
       }
       u.setAccountBalance(Double.parseDouble(nMoney) + Double.parseDouble(money) + "");
		try {
			bean.setCode(1);
			bean.setMsg(alipayClient.pageExecute(alipayRequest).getBody());
			userService.updatePassWord(u);
			writer = response.getWriter();
			
			writer.write(JSONObject.fromObject(bean).toString());
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	  
	   
}
