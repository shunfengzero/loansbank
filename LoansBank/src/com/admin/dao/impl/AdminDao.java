package com.admin.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.admin.dao.IAdminDao;
import com.admin.entity.Admin;
import com.loans.util.HibernateUtil;

public class AdminDao implements IAdminDao {

	@Override
	public void add(Admin t) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t);
		
		transaction.commit();
		session.close();
		
	}

	@Override
	public void delete(Admin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Admin t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByName(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Admin where name=:aname");
		query.setParameter("aname", name);
		
		Admin admin = (Admin)query.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return admin;
	}

}
