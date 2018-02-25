package com.loans.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.loans.dao.IInvestDao;
import com.loans.entity.Invest;
import com.loans.entity.Users;
import com.loans.util.HibernateUtil;

public class InvestDao implements IInvestDao{

	@Override
	public void add(Invest t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(t);
		
		transaction.commit();
		session.close();
		
	}

	@Override
	public void deleteById(Invest t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Invest t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		session.update(t);
		
		tran.commit();
		session.close();
	
	}

	@Override
	public List<Invest> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invest findAllById(Invest t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invest findAllByName(Invest t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Invest where username = :ename");
		query.setParameter("ename", t.getUserName());
		Invest i = (Invest) query.uniqueResult();
		
		tran.commit();
		session.close();
		
		return i;
	}
	
	
	public List<Invest> findAllList(Invest t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		
		Query query = session.createQuery("from Invest where username = :ename");
		query.setParameter("ename", t.getUserName());
		List<Invest> list = query.list();
		
		
		tran.commit();
		session.close();
		
		return list;
	}

}
