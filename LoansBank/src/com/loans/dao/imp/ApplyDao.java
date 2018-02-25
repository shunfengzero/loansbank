package com.loans.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.loans.dao.IApplyDao;
import com.loans.entity.Apply;
import com.loans.entity.Users;
import com.loans.util.HibernateUtil;

public class ApplyDao implements IApplyDao {

	@Override
	public void add(Apply t) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t);
		
		transaction.commit();
		session.close();
		
	}

	@Override
	public void deleteById(Apply t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Apply t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Apply> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Apply findAllById(Apply t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Apply where id = :eid");
		query.setParameter("eid", t.getId());
		Apply a = (Apply) query.uniqueResult();
		
		tran.commit();
		session.close();
		
		return a;
	}

	@Override
	public Apply findAllByName(Apply t) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
