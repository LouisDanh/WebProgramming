package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory factory;
	private static Session session;
	static {
		factory = new Configuration().configure("hibernate.cfg.xml").addPackage("models").buildSessionFactory();
	}


	public static Session getSession() {
		if (session == null || !session.isOpen()) {
			session = factory.openSession();
		}
		return session;
	}

	public static Transaction getCurrentTransaction() {
		Transaction transaction = session.getTransaction();
		return transaction.isActive() ? transaction : session.beginTransaction();
	}

	public static void closeFactory() {
		factory.close();
	}
}
