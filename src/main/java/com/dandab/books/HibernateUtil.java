package com.dandab.books;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Dana Dabbagh
 */
public class HibernateUtil
{
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static StandardServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory()
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
