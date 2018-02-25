package com.admin.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.admin.entity.Admin;
import com.admin.service.IAdminService;
import com.admin.service.impl.AdminService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private IAdminService adminService = new AdminService();
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Admin admin;
	
	public AdminAction() throws UnsupportedEncodingException {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	} 
	
	@Override
	public Admin getModel() {
		if (admin == null) {
			admin = new Admin();
		}
		return admin;
	}
	
	//添加
	public void addAdminator() throws IOException{
		
		System.out.println("admin" + admin.toString());
		JsonBean bean = new JsonBean();
		try{
			System.out.println("add");
			boolean flag = adminService.findByName(admin);
			
			if (flag) {
				adminService.addAdmin(admin);
				bean.setCode(1);
			} else {
				bean.setCode(0);
				bean.setMsg("账号已经存在");
			}
			
		} catch(Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		
	}
	
	/**
	 * 登录
	 * @throws IOException 
	 */
	public void login() throws IOException{
		System.out.println("admin" + admin.toString());
		JsonBean bean = new JsonBean();
		try{
			System.out.println("find");
			boolean flag = adminService.login(admin);
			
			if (flag) {
				bean.setCode(1);
				
			} 
			
			//将用户登录信息放入session中
			HttpSession session = request.getSession(false);
			if (session == null){
				session = request.getSession();
			}
			session.setAttribute("loginuser", admin.getName());
			
		} catch(Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		
	}
	
	
	public void logout() throws IOException {

		JsonBean bean = new JsonBean();
		HttpSession session2 = request.getSession(false);
		if (session2 != null) {
			session2.invalidate();
			bean.setCode(1);
			
		} else {
			bean.setCode(0);
			bean.setMsg("删除失败");
		}
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		
	}
	
}
