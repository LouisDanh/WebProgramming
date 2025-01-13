import org.hibernate.Session;

import models.Brand;
import utils.HibernateUtil;

public class TestHibernate {
	public static void main(String[] args) {
		// Lấy session
		Session session = HibernateUtil.getSession();
		try {
			// Bắt đầu transaction
			session.beginTransaction();

		
			// Commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeFactory();
		}
	}
}
