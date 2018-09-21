package com.atm.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class SessionCreation {

	static Session session;
	
	public static Session getSession()
	{
		Configuration cfg= new AnnotationConfiguration();
		SessionFactory factory=cfg.configure().buildSessionFactory();
		session= factory.openSession();
		
		return session;
	}
}
