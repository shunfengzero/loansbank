package com.admin.service.impl;

import com.admin.dao.IAdminDao;
import com.admin.dao.impl.AdminDao;
import com.admin.entity.Admin;
import com.admin.service.IAdminService;
import com.loans.vo.JsonBean;

import net.sf.json.JSONObject;

public class AdminService implements IAdminService {
	private IAdminDao adminDao = new AdminDao();
	
	@Override
	public void addAdmin(Admin admin) {
		
		try {
			if (admin == null || admin.equals("")){
				throw new RuntimeException("管理员信息不能为空");
			}
			adminDao.add(admin);			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("管理员信息注册异常，请重新注册");
		}
	}

	@Override
	public boolean login(Admin admin) {

		try {
			if (admin == null || admin.equals("")){
				throw new RuntimeException("登录信息信息不能为空");
			}
			
			//adminDao.findById(admin.getId());
			Admin admindb = adminDao.findByName(admin.getName());
			//判断管理员是否存在
			if (admindb == null) {
				throw new RuntimeException("管理员信息不存在");
			} else {
				if (admindb.getName().equals(admin.getName()) && admindb.getPwd().equals(admin.getPwd())) {
					return true;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("管理员登录异常，请重新登录");
		}
		return false;
	}

	@Override
	public boolean findByName(Admin admin) {
		try{
			Admin admindb = adminDao.findByName(admin.getName());
			
			if (admindb == null) {
				return true;
			} 
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		return false;
		
	}

}

















