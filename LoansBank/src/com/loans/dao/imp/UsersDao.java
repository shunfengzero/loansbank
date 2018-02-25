package com.loans.dao.imp;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;


import org.hibernate.Query;


import com.loans.dao.IUsersDao;
import com.loans.entity.Apply;
import com.loans.entity.Users;
import com.loans.util.HibernateUtil;


public class UsersDao implements IUsersDao{
	@Override
	public void add(Users u) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(u);
		
		transaction.commit();
		session.close();
		
		
	}

	@Override
	public void deleteById(Users t) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.delete(t);
		
		transaction.commit();
		session.close();
		
		
	}

	@Override
	public void update(Users t) {
		
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		session.update(t);
		
		tran.commit();
		session.close();
	
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Users");
		List<Users> list = query.list();
		
		tran.commit();
		session.close();
		
		return list;
	}

	@Override
	public Users findAllById(Users t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Users where id = :eid");
		query.setParameter("eid", t.getId());
		Users u = (Users) query.uniqueResult();
		
		tran.commit();
		session.close();
		
		return u;
	}

	@Override
	public Users findAllByName(Users t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Users where username = :ename");
		query.setParameter("ename", t.getUserName());
		Users u = (Users) query.uniqueResult();
		
		tran.commit();
		session.close();
		
		return u;
	}

	/**
	 * 查询
	 */
	@Override
	public List<Apply> getUserInfoByName(Users t) {
		// TODO Auto-generated method stub
		List<Apply> list = null;
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Apply where username = :ename");
		query.setParameter("ename", t.getUserName());
		list = query.list();
		
		tran.commit();
		session.close();
		
		return list;
	}

	


}
