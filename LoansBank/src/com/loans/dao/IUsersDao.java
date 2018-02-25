package com.loans.dao;

import java.util.List;

import com.loans.baseDao.IBaseDao;
import com.loans.entity.Apply;
import com.loans.entity.Users;



/**
 * 用户注册数据库操作
 * @author shunfeng
 *
 * 2017年10月4日
 */
public interface IUsersDao extends IBaseDao<Users>{
	public List<Apply> getUserInfoByName(Users t);
}
