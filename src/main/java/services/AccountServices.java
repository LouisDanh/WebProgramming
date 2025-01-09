package services;

import dao.GenericDao;
import models.Account;
import models.Customer;
import utils.AccountUtil;
import utils.QueryUtil;

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
		String condition = QueryUtil.createCondition("email", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Account.class, "id", condition);
		return GenericDao.excuteQueryGetSingle(Account.class, Integer.class, query, email);
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
		Integer id = getIdAccount(email);
		if (id == null)
			return null;
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Account.class, "password", condition);
		String storedPassword = GenericDao.excuteQueryGetSingle(Account.class, String.class, query, id);
		return AccountUtil.verifyPassword(password, storedPassword) ? id : null;

	}

	/**
	 * Tạo tài khoản
	 * 
	 * @param acc dữ liệu về tài khoản
	 * @return
	 */
	public static boolean createAccount(Account acc) {
		acc.setPassword(AccountUtil.hashPassword(acc.getPassword()));
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
	 * Lấy thông tin account thông qua accountId
	 * 
	 * @param accountId
	 * @return account, ngược lại null
	 */
	public static Account getAccount(Integer accountId) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Account.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Account.class, Account.class, query, accountId);
	}

	/**
	 * Cập nhật thông tin account
	 * 
	 * @param account
	 * @return account, ngược lại null
	 */
	public static boolean updateAccount(Account account) {
		boolean customerUpdate = GenericDao.update(account.getCustomer(), true);
		boolean accountUpdate = GenericDao.update(account, true);
		return customerUpdate && accountUpdate;

	}

	/**
	 * Kiểm tra mật khẩu hiện tại của tài khoản.
	 * 
	 * @param accountId       ID của tài khoản cần kiểm tra.
	 * @param currentPassword Mật khẩu hiện tại cần so sánh.
	 * @return true nếu mật khẩu khớp, ngược lại false.
	 */
	public boolean checkPassword(Integer accountId, String currentPassword) {
	    // Tạo câu query với đúng kiểu dữ liệu cho tham số
	    String queryString = QueryUtil.createQuery(
	        Account.class, 
	        QueryUtil.ALL, 
	        QueryUtil.createCondition("password", QueryUtil.EQUALS, 0, QueryUtil.EMPTY),
	        QueryUtil.createCondition("id", QueryUtil.EQUALS, 1, QueryUtil.EMPTY)  // Thêm điều kiện cho accountId
	    );

	    // Thực thi query với accountId kiểu Integer
	    Account account = GenericDao.excuteQueryGetSingle(Account.class, Account.class, queryString, accountId);

	    // Kiểm tra mật khẩu
	    return account != null && account.getPassword().equals(currentPassword);
	}


}