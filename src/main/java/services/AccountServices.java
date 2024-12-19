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
		return GenericDao.findOne(Account.class, "id", "email", QueryFactory.EQUALS, email);
	}

	/**
	 * Đăng nhập
	 * 
	 * @param id
	 * @param password
	 * @return true nếu thành công
	 */
	public static boolean login(int id, String password) {
		Boolean isLogin = GenericDao.findOne(Account.class, "password", QueryFactory.EQUALS, password, QueryFactory.AND,
				"id", QueryFactory.EQUALS, id);
		return isLogin != null;
	}

	/**
	 * Tạo tài khoản
	 * 
	 * @param acc dữ liệu về tài khoản
	 * @return
	 */
	public static boolean createAccount(Account acc) {
		return GenericDao.insert(acc);
	}

	public static boolean updateCustomer(Customer customer) {
		return GenericDao.update(customer);
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
		return GenericDao.update(account);
	}

}
