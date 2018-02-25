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

import com.admin.entity.Admin;
import com.loans.entity.Apply;
import com.loans.entity.Invest;
import com.loans.entity.Users;
import com.loans.util.HibernateUtil;
import com.loans.vo.JsonBean;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

/**
 * @description 后台人员管理
 * @author 耿清
 * @time 17-10-5
 *
 */
public class FindUsersAction extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public FindUsersAction() throws UnsupportedEncodingException {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	public void findUsers() throws IOException {
		System.out.println("---------------findUsers-----------------");

		// 获取当前页面
		String cp = request.getParameter("cp");
		int c = Integer.parseInt(cp);
		System.out.println("cp :" + c);

		// 加载数据
		load(c);

		System.out.println("---------------findUsers_end-----------------");
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
			Users user = (Users) session.get(Users.class, i);
			System.out.println(user.getUserName());
			session.delete(user);
			// 加载数据
			load(c);
			tran.commit();
			session.close();
			json.setCode(1);
			json.setCurrentPage(c);
			json.setPage(i);
			
		} catch(Exception e) {
			json.setCode(0);
			json.setMsg(e.getMessage());
			
		}
		System.out.println("---------------deleteUser_end-----------------");
	}

	public void editorUser() throws IOException {
		System.out.println("---------------editorUsers-----------------");
		String id = request.getParameter("id");
		System.out.println(id);
		// 添加所有用户到域中
		List<Users> l = new ArrayList();
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		Query query = session.createQuery("from Users");

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
		System.out.println("---------------editorUsers_end-----------------");
	}

	/**
	 * 添加用户
	 * 
	 * @throws IOException
	 */
	public void addUser() throws IOException {
		System.out.println("---------------addUser--------------");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String telePhone = request.getParameter("telePhone");
		String address = request.getParameter("address");
		String registTime = request.getParameter("registTime");

		// delete
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		Users user = new Users();
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setRealName(realName);
		user.setGender(gender);
		user.setEmail(email);
		user.setTelePhone(telePhone);
		user.setAddress(address);
		user.setRegistTime(registTime);
		session.save(user);

		// 加载数据
		load(1);

		System.out.println("---------------deleteUser_end-----------------");
	}

	public void updateUser() throws IOException {
		System.out.println("---------------updateUser--------------");
		String id = request.getParameter("id");
		System.out.println("-----------------id:" + id);
		int i = Integer.parseInt(id);
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String telePhone = request.getParameter("telePhone");
		String address = request.getParameter("address");
		String registTime = request.getParameter("registTime");
		String page = request.getParameter("page");
		int c = Integer.parseInt(page);

		System.out.println("------------------id:" + i + "-------------------");
		// delete
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		Users user = (Users) session.get(Users.class, i);
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setRealName(realName);
		user.setGender(gender);
		user.setEmail(email);
		user.setTelePhone(telePhone);
		user.setAddress(address);
		user.setRegistTime(registTime);
		session.update(user);

		// 加载数据
		load(c);
		JsonBean bean = new JsonBean();
		try {
			bean.setCode(1);
			
		} catch(Exception e) {
			bean.setMsg(0);
			bean.setMsg(e.getMessage());
		}
		tran.commit();
		session.close();
				
		System.out.println("---------------deleteUser_end-----------------");
	}

	public void load(int cpage) throws IOException {
		System.out.println("---------------load-----------------");

		List<Users> lUsers = new ArrayList();
		JsonBean bean = new JsonBean();
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();

		// 获取users总数
		Query count = session.createQuery("select count(1) from Users");
		long lAll = (long) count.uniqueResult();
		
		System.out.println("----------------lAll:"+lAll);
		Query query = session.createQuery("from Users");
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

	public void findApplication() throws IOException{
		System.out.println("---------------findApplication-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);
		
		System.out.println("---------------findApplication---i:"+ i +"-----------------");
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		JsonBean bean = new JsonBean();
		
		Query query = session.createQuery("from Apply where id=:aid");
		query.setParameter("aid", i);
		Apply apply2 = (Apply)query.uniqueResult();
		
		System.out.println("-----------apply2: " + apply2.toString());
		try {

			bean.setPage(1);
			bean.setCurrentPage(1);
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch(Exception e) {
			System.out.println("---------------catch------------");
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		tran.commit();
		session.close();
		System.out.println("打印findApplication："
				+ JSONObject.fromObject(bean).toString());
		
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
	

	public void findInvest() throws IOException{
		System.out.println("---------------findInvest-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);
		
		System.out.println("---------------findInvest---i:"+ i +"-----------------");
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		JsonBean bean = new JsonBean();
		
		Query query = session.createQuery("from Invest where id=:aid");
		query.setParameter("aid", i);
		Invest apply2 = (Invest)query.uniqueResult();
		
		System.out.println("-----------apply2: " + apply2.toString());
		try {

			bean.setPage(1);
			bean.setCurrentPage(1);
			bean.setCode(1);
			bean.setMsg(apply2);
		} catch(Exception e) {
			System.out.println("---------------catch------------");
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		
		tran.commit();
		session.close();
		System.out.println("打印findInvest："
				+ JSONObject.fromObject(bean).toString());
		
		response.getWriter().write(JSONObject.fromObject(bean).toString());
		System.out.println("--------------findInvest_end-----------------");
	}

	public void approveInvest() throws IOException {

		System.out.println("--------------approve_Invest-----------------");
		String id = request.getParameter("id");
		Integer i = Integer.parseInt(id);
			
		//查询
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
	
	
	public void modify() throws IOException {

		System.out.println("--------------modify-----------------");
		
		String name = request.getParameter("name");
		System.out.println(name);
		//查询
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Admin where name=:name");
		query.setParameter("name", name);

		Admin apply2 = (Admin) query.uniqueResult();
		
		System.out.println(apply2.toString());

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
		
		System.out.println("--------------modify_end-----------------");
	}
	
	public void modifyAdmin() throws IOException {

		System.out.println("--------------modifyAdmin-----------------");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("==========id:" + id);
		System.out.println(name);
		//查询
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Admin where id=:id");
		query.setParameter("id", id);

		Admin apply2 = (Admin) query.uniqueResult();
		apply2.setName(name);
		apply2.setPwd(pwd);
		
		session.update(apply2);
		
		
		System.out.println(apply2.toString());

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
		
		System.out.println("--------------modify_end-----------------");
	}
}