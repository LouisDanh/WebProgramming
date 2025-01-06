package services;

import dao.GenericDao;
import dao.QueryFactory;
import models.Account;
import models.Customer;

public class AccountServices {
	/**
	 * Lấy id tài khoản từ thông tin email
	 * 
	 * @param email
	 * @return id nếu tồn tại, ngược lại null
	 */
	public static Integer getIdAccount(String email) {
		if (email == null || email.isBlank()) {
			System.err.println("Email null hoặc rỗng");
			return null;
		}
		return GenericDao.findOne(Account.class, "id", "email", QueryFactory.EQUALS, email);
	}

	/**
	 * Đăng nhập
	 * 
	 * @param id
	 * @param password
	 * @return true nếu thành công
	 */
	public static Integer login(String email, String password) {
		if (email == null || email.isBlank() || password == null || password.isBlank()) {
			System.err.println("Email hoặc pass null hoặc rỗng");
			return null;
		}
		return GenericDao.findOne(Account.class, "id", "password", QueryFactory.EQUALS, password,
				"email", QueryFactory.EQUALS, email);
		
	}

	/**
	 * Tạo tài khoản
	 * 
	 * @param acc dữ liệu về tài khoản
	 * @return
	 */
	public static boolean createAccount(Account acc) {
		if (GenericDao.insert(acc.getCustomer(), false) && GenericDao.insert(acc, false)) {
			GenericDao.commit();
			return true;
		}
		return false;
	}

	public static boolean updateCustomer(Customer customer) {
		return GenericDao.update(customer, true);
	}

	/**
	 * Lấy thông tin customer
	 * 
	 * @param accountId
	 * @return custome, ngược lại null
	 */
	public static Customer getCustomer(Integer accountId) {
		return GenericDao.findOne(Customer.class, "*", "id", QueryFactory.EQUALS, accountId);
	}

	/**
	 * Lấy thông tin tài khoản từ accountId
	 * 
	 * @param
	 * @return account, ngược lại null
	 */
	public static Account getAccount(Integer accountId) {
		return GenericDao.findOne(Account.class, "*", "id", QueryFactory.EQUALS, accountId);
	}

	public static boolean updateAccount(Account account) {
		return GenericDao.update(account, true);
	}

}
