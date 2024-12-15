import org.hibernate.Session;

import dao.HibernateUtil;
import models.Bank;

public class TestHibernate {
	public static void main(String[] args) {
		// Lấy session
		Session session = HibernateUtil.getSession();
		try {
			// Bắt đầu transaction
			session.beginTransaction();

			// Tạo đối tượng Product
			Bank bank = new Bank("Viettinbank");

			// Lưu đối tượng vào database
			session.save(bank);

			// Commit transaction
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeFactory();
		}
	}
}
