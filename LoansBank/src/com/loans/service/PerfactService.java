package com.loans.service;

import com.loans.dao.imp.UsersDao;
import com.loans.entity.Users;

public class PerfactService {

	
	UsersDao usersDao = new UsersDao();
	
	public void perfact(Users u) {
		
		if (u == null) {
			throw new RuntimeException("信息异常");
		}
		
		Users f = usersDao.findAllByName(u);
		if (f == null) {
			throw new RuntimeException("注册信息异常");
		}  else {
			
			try {
				u.setId(f.getId());
				u.setPassWord(f.getPassWord());
				u.setGender(f.getGender());
				u.setEmail(f.getEmail());
				u.setIntroduce(f.getIntroduce());
				u.setRegistTime(f.getRegistTime());
				usersDao.update(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("完善信息异常");
			}
		
		}
	}
	
	
	
}
