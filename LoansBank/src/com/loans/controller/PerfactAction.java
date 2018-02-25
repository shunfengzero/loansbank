package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.loans.entity.Users;
import com.loans.service.PerfactService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class PerfactAction extends ActionSupport implements ModelDriven<Users>{
	private PerfactService perfactService = new PerfactService();
	 Users users;
	
	@Override
	public Users getModel() {
		
		if (users == null) {
			users = new Users();
		}
		
		return users;
	}
	
	public void perfact() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		String userName = (String)session.getAttribute("loginuser");
		users.setUserName(userName);
		JsonBean bean = new JsonBean();
		System.out.println("--------------");
		System.out.println(users.getUserName());
		System.out.println(users.getRealName());
		System.out.println(users.getIdType());
		System.out.println(users.getIdNumber());
		System.out.println(users.getTelePhone());
	
		System.out.println(users.getIdImg());
		System.out.println(users.getAddress());
		System.out.println(users.getAddressWork());
		System.out.println(users.getBankType());
		System.out.println(users.getBankNumber());
		System.out.println("------------");
		
		try {
			perfactService.perfact(users);
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
	
}













