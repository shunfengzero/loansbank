package com.admin.service;

import com.admin.entity.Admin;

public interface IAdminService {

	public void addAdmin(Admin admin);

	public boolean findByName(Admin admin);
	public boolean login(Admin admin);

}
