package com.loans.service;

import java.util.List;

import com.loans.dao.IUsersDao;
import com.loans.dao.imp.UsersDao;
import com.loans.entity.Apply;
import com.loans.entity.Users;
import com.loans.util.StringUtil;

/**
 * 登录、注销
 * @author Marshal
 *
 */
public class LogService {

	private IUsersDao userDao = new UsersDao();
	
	public void login(Users user) {
		
		boolean ret = StringUtil.strIsEmpty(user.getUserName());
		if (ret == true) {
			throw new RuntimeException("用户名不能为空");
		}
		ret = StringUtil.strIsEmpty(user.getPassWord());
		if (ret == true) {
			throw new RuntimeException("密码不能为空");
		}
		//参数合法性判断
		Users users = userDao.findAllByName(user);
		if (users == null) {
			throw new RuntimeException("用户不存在");
		}
		if (!user.getPassWord().equals(users.getPassWord())) {
			throw new RuntimeException("密码不正确");
		}
	}
	
	/**
	 * 查询已经登录的用户的业务信息
	 * 如：借款、还款、投资信息
	 * @param user
	 */
	public List<Apply> getLoginUserInfo(Users user) {
		
		List<Apply> list = null;
		System.out.println("LogService : " + user.getUserName());
		//参数合法性判断
		list = userDao.getUserInfoByName(user);
		if (list == null || list.size() == 0) {
			throw new RuntimeException("用户不存在");
		}
		
		return list;
		
	}
	
	
}














