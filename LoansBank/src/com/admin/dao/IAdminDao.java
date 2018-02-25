package com.admin.dao;

import com.admin.dao.basedao.IBaseDao;
import com.admin.entity.Admin;

public interface IAdminDao extends IBaseDao<Admin> {

	public Admin findByName(String name);
	
}
