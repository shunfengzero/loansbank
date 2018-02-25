package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.loans.entity.Users;
import com.loans.service.RegisterService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class RegisterAction extends ActionSupport implements ModelDriven<Users>{

	Users users;
	 
	@Override
	public Users getModel() {
		
		if (users == null) {
			users = new Users();
		}
		
		return users;
	}
	
	public void register() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.setCharacterEncoding("utf-8");
		/*String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String telePhone = request.getParameter("telePhone");
		String address = request.getParameter("address");
		String introduce = request.getParameter("introduce");*/
		/*String activeCode = request.getParameter("activeCode");
		String state = request.getParameter("state");
		String role = request.getParameter("role");
		String registerTime = request.getParameter("registTime");*/
		
	
		/*users.setUserName(userName);
		users.setPassWord(passWord);
		users.setRealName(realName);
		users.setGender(gender);
		users.setEmail(email);
		users.setTelePhone(telePhone);
		users.setAddress(address);
		users.setIntroduce(introduce);*/
		RegisterService rs = new RegisterService();
		JsonBean bean = new JsonBean();
		
		System.out.println(users.getRealName());
		System.out.println("=======");
		System.out.println(users.getIdImg());
		try {
			rs.registerService(users);
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
