package com.loans.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sessionFactory = null;
	
	static {
		//获取对象
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	
	/**
	 * 获取session对象
	 * @return
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
