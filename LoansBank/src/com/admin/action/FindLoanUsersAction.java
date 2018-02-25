package com.admin.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.loans.entity.Apply;
import com.loans.entity.Invest;
import com.loans.entity.Users;
import com.loans.entity.Apply;
import com.loans.util.HibernateUtil;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class FindLoanUsersAction extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public FindLoanUsersAction() throws UnsupportedEncodingException {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	public void findUsers() throws IOException {
		System.out.println("---------------findApply-----------------");

		// 获取当前页面
		String cp = request.getParameter("cp");
		int c = Integer.parseInt(cp);
		System.out.println("cp :" + c);

		// 加载数据
		load(c);

		System.out.println("---------------findApply_end-----------------");
	}

	public void deleteUser() throws IOException {
		System.out.println("---------------deleteUser--------------");
		String id = request.getParameter("id");
		int i = Integer.parseInt(id);
		String cp = request.getParameter("cp");
		Integer c = Integer.parseInt(cp);

		System.out.println("------------------id:" + i + "-------------------");

		JsonBean json = new JsonBean();
		try {
			// delete
			Session session = HibernateUtil.getSession();
			Transaction tran = session.beginTransaction();
			Apply user = (Apply) session.get(Apply.class, i);
			System.out.println(user.getUserName());
			session.delete(user);
			// 加载数据
			load(c);
			tran.commit();
			session.close();
			json.setCode(1);
			json.setCurrentPage(c);
			json.setPage(i);

		} catch (Exception e) {
			json.setCode(0);
			json.setMsg(e.getMessage());

		}
		System.out.println("---------------deleteUser_end-----------------");
	}

	public void editorUser() throws IOException {
		System.out.println("---------------editorApply-----------------");
		String id = request.getParameter("id");
		System.out.println(id);
		// 添加所有用户到域中
		List<Apply> l = new ArrayList();
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery("from Apply");

		l = query.list();

		JsonBean bean = new JsonBean();

		try {
			bean.setPage(l.size());
			bean.setCode(1);
			bean.setMsg(l);

		} catch (Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		System.out.println("打印cuisine：" + JSONObject.fromObject(bean).toString());
		tran.commit();
		session.close();
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		System.out.println("---------------editorApply_end-----------------");
	}

	/**
	 * 添加用户
	 * 
	 * @throws IOException
	 */
	public void addUser() throws IOException {
		System.out.println("---------------addUser--------------");
		String userName = request.getParameter("userName");
		String limitMoney = request.getParameter("limitMoney");
		String clazz = request.getParameter("clazz");
		String limitTime = request.getParameter("limitTime");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");

		// delete
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		Apply user = new Apply();
		user.setUserName(userName);
		user.setLimitMoney(Integer.parseInt(limitMoney));
		user.setClazz(clazz);
		user.setLimitTime(limitTime);
		user.setPhone(phone);
		user.setAddress(address);
		user.setStatus(status);

		// 加载数据
		load(1);

		System.out.println("---------------deleteUser_end-----------------");
	}

	public void updateUser() throws IOException {
		System.out.println("---------------updateUser--------------");
		String id = request.getParameter("nid");
		System.out.println("-----------------id:" + id);
		int i = Integer.parseInt(id);

		String userName = request.getParameter("userName");
		String limitMoney = request.getParameter("limitMoney");
		String clazz = request.getParameter("clazz");
		String limitTime = request.getParameter("limitTime");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		String page = request.getParameter("page");
		int c = Integer.parseInt(page);

		System.out.println("------------------id:" + i + "-------------------");
		// delete
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		Apply user = (Apply) session.get(Apply.class, i);
		user.setUserName(userName);
		user.setLimitMoney(Integer.parseInt(limitMoney));
		user.setClazz(clazz);
		user.setLimitTime(limitTime);
		user.setPhone(phone);
		user.setAddress(address);
		user.setStatus(status);
		session.update(user);

		// 加载数据
		load(c);
		System.out.println("---------------deleteUser_end-----------------");
	}

	public void load(int cpage) throws IOException {
		System.out.println("---------------load-----------------");

		List<Apply> lUsers = new ArrayList();
		JsonBean bean = new JsonBean();
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		// 获取Apply总数
		Query count = session.createQuery("select count(*) from Apply");
		long lAll = (long) count.uniqueResult();

		Query query = session.createQuery("from Apply");
		query.setFirstResult(cpage * 10 - 10);
		query.setMaxResults(10);

		lUsers = query.list();
		Integer page = 1;
		if(lAll%10 == 0){
			 page = (int) lAll / 10;			
		}
		else{
			 page = (int) lAll / 10  + 1;
		}

		try {
			bean.setPage(page);
			bean.setCurrentPage(cpage);
			bean.setCode(1);
			bean.setMsg(lUsers);

		} catch (Exception e) {
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		System.out.println("打印cuisine：" + JSONObject.fromObject(bean).toString());
		tran.commit();
		session.close();

		response.getWriter().write(JSONObject.fromObject(bean).toString());
		System.out.println("---------------load_end-----------------");
	}

	public void findApplication() throws IOException {
		System.out.println("---------------findApplication-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);

		System.out.println("---------------findApplication---i:" + i + "-----------------");
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		JsonBean bean = new JsonBean();

		Query query = session.createQuery("from Apply where id=:aid");
		query.setParameter("aid", i);
		Apply apply2 = (Apply) query.uniqueResult();

		System.out.println("-----------apply2: " + apply2.toString());
		try {

			bean.setPage(1);
			bean.setCurrentPage(1);
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch (Exception e) {
			System.out.println("---------------catch------------");
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}

		tran.commit();
		session.close();
		System.out.println("打印findApplication：" + JSONObject.fromObject(bean).toString());

		response.getWriter().write(JSONObject.fromObject(bean).toString());
		System.out.println("--------------findApplication_end-----------------");
	}

	public void approveApplication() throws IOException {

		System.out.println("--------------approve_Application-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);

		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery("from Apply where id=:aid");
		query.setParameter("aid", i);

		Apply apply2 = (Apply) query.uniqueResult();

		apply2.setStatus("批准");

		session.update(apply2);

		JsonBean bean = new JsonBean();
		try {
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		System.out.println("打印findApplication：" + JSONObject.fromObject(bean).toString());
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		tran.commit();
		session.close();
		System.out.println("--------------approve_Application_end-----------------");
	}

	public void findInvest() throws IOException {
		System.out.println("---------------findInvest-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);

		System.out.println("---------------findInvest---i:" + i + "-----------------");
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		JsonBean bean = new JsonBean();

		Query query = session.createQuery("from Invest where id=:aid");
		query.setParameter("aid", i);
		Invest apply2 = (Invest) query.uniqueResult();

		System.out.println("-----------apply2: " + apply2.toString());
		try {

			bean.setPage(1);
			bean.setCurrentPage(1);
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch (Exception e) {
			System.out.println("---------------catch------------");
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}

		tran.commit();
		session.close();
		System.out.println("打印findInvest：" + JSONObject.fromObject(bean).toString());

		response.getWriter().write(JSONObject.fromObject(bean).toString());
		System.out.println("--------------findInvest_end-----------------");
	}

	public void approveInvest() throws IOException {

		System.out.println("--------------approve_Invest-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);

		// 查询
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery("from Invest where id=:aid");
		query.setParameter("aid", i);

		Invest apply2 = (Invest) query.uniqueResult();

		apply2.setInveststatus("批准");

		session.update(apply2);

		JsonBean bean = new JsonBean();
		try {
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		System.out.println("打印findInvest：" + JSONObject.fromObject(bean).toString());
		response.getWriter().write(JSONObject.fromObject(bean).toString());

		tran.commit();
		session.close();

		System.out.println("--------------approve_Invest_end-----------------");
	}

}
