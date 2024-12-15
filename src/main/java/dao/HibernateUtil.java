package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		factory = new Configuration().configure("hibernate.cfg.xml").addPackage("models").buildSessionFactory();
	}

	public static Session getSession() {
		return factory.getCurrentSession();
	}

	public static void closeFactory() {
		factory.close();
	}
}
