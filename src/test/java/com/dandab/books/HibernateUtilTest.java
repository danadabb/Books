package com.dandab.books;

import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * @author Dana Dabbagh
 */
public class HibernateUtilTest
{
	@Test
	public void getSessionFactoryShouldNotBeNull()
	{
		assertThat(HibernateUtil.getSessionFactory().openSession(), notNullValue());
	}

	@Test
	public void testOpenCloseFactorySession()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		assertThat(session.isOpen(), is(true));
		session.close();
		assertThat(session.isOpen(), is(false));
	}
}
