package com.admin.dao.basedao;

import java.util.List;

public interface IBaseDao<T> {
	/**
	 * 添加
	 * @param t 
	 */
	public void add(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 更新
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 查找所有
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 查找单个
	 * @param id
	 * @return
	 */
	public T findById(int id);
}
