package com.loans.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.loans.dao.imp.UsersDao;
import com.loans.entity.Users;

/**
 * 
 * @author shunfeng
 *
 * 2017年10月4日
 */
public class RegisterService {
  
	private UsersDao usersDao = new UsersDao();
	
	public void registerService(Users u) {
		
		if (u == null) {
			throw new RuntimeException("注册信息不完整");
		}
		
		Users user = usersDao.findAllByName(u);
		
		if (user != null) {
			throw new RuntimeException("改用户已被注册");
		}
		
		try {
			
			Date d = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = format.format(d);
			u.setRegistTime(time);
				System.out.println(u.getGender());
				
				
				
			usersDao.add(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("注册异常");
		}
		
	}
	
}
