package com.loans.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.loans.entity.Invest;
import com.loans.service.InvestService;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

/**
 * 
 * @author shunfeng
 *
 * 2017年10月7日
 */
public class InvestAction extends ActionSupport implements ModelDriven<Invest>{
	private InvestService iService = new InvestService();
	private Invest invt;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	@Override
	public Invest getModel() {
		
		if (invt == null) {
			invt = new Invest();
		}
		
		return invt;
	}
	
	
	public void invest() {
		
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JsonBean bean =  new JsonBean();
		HttpSession session = request.getSession();
		
		String userName = (String)session.getAttribute("loginuser");
		
		
		try {
			/*System.out.println(userName);
			System.out.println(invt.getiMoney());
			System.out.println(invt.getInvestMethod());
			System.out.println(invt.getWithDrawMethod());
			System.out.println(invt.getInvestTime());*/
			invt.setUserName(userName);
			 
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String investDate = format.format(d);
			invt.setInvestDate(investDate);
			
			iService.investService(invt);
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
	
	
	public void investMoney() {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JsonBean bean =  new JsonBean();
		HttpSession session = request.getSession();
		
		
		String userName = (String)session.getAttribute("loginuser");
		invt.setUserName(userName);
		
		
		try {
			List<Invest> list = iService.investMoney(invt);
			bean.setCode(1);
			bean.setMsg(list);
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
