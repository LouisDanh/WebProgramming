package utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
	public static Session createSessionWithTimeout(int timeoutSeconds) {
		final Session session = factory.openSession();
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.schedule(() -> {
			if (session.isOpen()) {
				session.close();
			}
		}, timeoutSeconds, TimeUnit.SECONDS);
		return session;
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
