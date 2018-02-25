package com.loans.service;

import com.loans.dao.IUsersDao;
import com.loans.dao.imp.UsersDao;
import com.loans.entity.Users;

public class UserService {

	private IUsersDao userDao = new UsersDao();
	private Users user = new Users();
	
	
	public Users myBankCar(Users user) {
		Users users = null;
		try {
			users = userDao.findAllByName(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("请重新登录");
		}
		
		return users;
	}
	
	//修改密码
	public void updatePassWord(Users user) {
		
		try {
			userDao.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改密码失败");
		}
		
	}

	//添加
	public void add(Users user) {
		
		try {
			userDao.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("充值失败");
		}
	}

	
}
