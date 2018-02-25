package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.loans.entity.Apply;
import com.loans.entity.Users;
import com.loans.service.LogService;
import com.loans.util.StringUtil;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;
/**
 * 登录、注销Action
 * @author Marshal
 *
 */
public class LogAction extends ActionSupport implements ModelDriven<Users>{

	private Users user = null;
	
	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		if (user == null) {
			user = new Users();
		}
		return user;
	}
	
	private LogService logService = new LogService();
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	
	/**
	 * 登录
	 */
	public void login() {
	
		JsonBean jsonBean = new JsonBean();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		
		
		try {
			//如果没有抛出异常，说明用户名合法(即用户已注册且密码正确)
			logService.login(user);
			//将用户登录信息放入session中
			HttpSession session = request.getSession(false);
			if (session == null) {
				session = request.getSession();
			}
			session.setAttribute("loginuser", user.getUserName());
			session.setAttribute("login", user);
			
			jsonBean.setCode(1);
		} catch(Exception e) {
			jsonBean.setCode(0);
			jsonBean.setMsg(e.getMessage());//{"msg":"用户名不存在","code":0}
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将数据写入浏览器
		out.write(JSONObject.fromObject(jsonBean).toString());
		//关闭资源
		out.close();
	}
	
	/**
	 * 判断用户是否登录
	 */
	public void isLogin() {
		JsonBean jsonBean = new JsonBean();
		HttpSession session = request.getSession(false);
		//如果用户已未登录
		if (session == null || StringUtil.strIsEmpty((String) session.getAttribute("loginuser"))) {
			jsonBean.setCode(0);
		} else {
			jsonBean.setCode(1);
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将数据写入浏览器
		out.write(JSONObject.fromObject(jsonBean).toString());
		//关闭资源
		out.close();
	}
	
	/**
	 * 获取已登录用户的信息
	 */
	public void loginUserInfo() {
		
		JsonBean jsonBean = new JsonBean();
		List<Apply> list = null;
		HttpSession session = request.getSession(false);
		//如果用户未登录
		if (session == null || StringUtil.strIsEmpty((String) session.getAttribute("loginuser"))) {
			jsonBean.setCode(0);
		} else {
			Enumeration<String> enums = session.getAttributeNames();
			while (enums.hasMoreElements()) {
				String name = enums.nextElement();
				if (name.equals("loginuser")) {
					String userName = (String) session.getAttribute(name);
					Users u = new Users();
					u.setUserName(userName);
					try {
						list = logService.getLoginUserInfo(u);
						jsonBean.setCode(1);
						jsonBean.setMsg(list);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						jsonBean.setCode(0);
						jsonBean.setMsg(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将数据写入浏览器
		out.write(JSONObject.fromObject(jsonBean).toString());
		//关闭资源
		out.close();
		
	}
	
	
	/**
	 * 注销
	 */
	public void logout() {
		
		JsonBean jsonBean = new JsonBean();
		/**
		 * 通过销毁session，实现用户退出登录
		 */
		HttpSession session = request.getSession(false);
		if (session == null) {
			throw new RuntimeException("用户未登录");
		}
		Enumeration<String> enums = session.getAttributeNames();
		while (enums.hasMoreElements()) {
			String name = enums.nextElement();
			if (name.equals("loginuser") || name.equals("login")) {
				session.invalidate();
				jsonBean.setCode(1);
			}
			
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将数据写入浏览器
		out.write(JSONObject.fromObject(jsonBean).toString());
		//关闭资源
		out.close();
	}

	
	
}
