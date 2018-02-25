package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.loans.entity.Apply;
import com.loans.service.ApplyService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class ApplyAction extends ActionSupport{

	
	
	
	
	
	public void apply() {
		System.out.println("apply");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		//获取用户都登录名
		String userName = null;
		HttpSession session = request.getSession(false);
		if (session == null) {
			throw new RuntimeException("用户未登录");
		}
		Enumeration<String> enums = session.getAttributeNames();
		while (enums.hasMoreElements()) {
			String name = enums.nextElement();
			if (name.equals("loginuser")) {
				userName = (String) session.getAttribute(name);
			}
			
		}
		//设置编码
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		 //设置参数
		 Apply ay = new Apply();
		 String limitMoney = request.getParameter("limitMoney");
		 String limitTime = request.getParameter("limitTime");
		 String realName = request.getParameter("realName");
		 String phone = request.getParameter("phone");
		 String address = request.getParameter("address");
		 
		 Date d = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 String applyTime = format.format(d);
		 ay.setApplyTime(applyTime);
		 
		 ay.setLimitMoney(Integer.parseInt(limitMoney));
		 ay.setLimitTime(limitTime);
		 ay.setUserName(userName);
		 ay.setRealName(realName);
		 ay.setPhone(phone);
		 ay.setAddress(address);
		 System.out.println(limitMoney);
		 System.out.println(limitTime);
		 System.out.println(userName);
		 System.out.println(realName);
		 System.out.println(phone);
		 System.out.println(address);
		 System.out.println(applyTime);
		
		ApplyService applyService = new ApplyService();
		JsonBean bean = new JsonBean();
		
		try {
			applyService.Apply2(ay);
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writer.close();
		
	}

}
