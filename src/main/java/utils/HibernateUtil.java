package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;

	static {
		factory = new Configuration().configure("hibernate.cfg.xml").addPackage("models").buildSessionFactory();
	}

	public static Session getCurrentSession() {
		return factory.getCurrentSession();
	}

	public static Session getSession() {
		return factory.openSession();
	}

	public static Transaction getCurrentTransaction() {
		Session session = getCurrentSession();
		Transaction transaction = session.getTransaction();
		return transaction.isActive() ? transaction : session.beginTransaction();
	}

	public static void closeFactory() {
		factory.close();
	}
}
