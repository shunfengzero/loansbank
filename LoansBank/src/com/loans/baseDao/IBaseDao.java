package com.loans.baseDao;

import java.util.List;

import com.loans.entity.Users;

public interface IBaseDao<T> {
	/**
	 * 增
	 * @param t
	 */
	public void add(T t);
	
	/**
	 * 删 一般通过主键删除
	 * @param user
	 */
	public void deleteById(T t);
	
	
	/**
	 * 改
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 查  查可分为 查找全部  查找单个对象
	 * @return
	 */
	public List<T> findAll();
	public T findAllById(T t);
	public T findAllByName(T t);
}
