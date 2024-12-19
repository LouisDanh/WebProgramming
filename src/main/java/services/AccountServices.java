package services;

import dao.GenericDao;
import dao.QueryFactory;
import models.Account;

public class AccountServices {
	/**
	 * Lấy id tài khoản từ thông tin email
	 * 
	 * @param email
	 * @return id nếu tồn tại, ngược lại null
	 */
	public static Integer getIdAccount(String email) {
		return GenericDao.findOne(Account.class,"id", "email", QueryFactory.EQUALS, email);
	}

	/**
	 * Đăng nhập
	 * 
	 * @param id
	 * @param password
	 * @return true nếu thành công
	 */
	public static boolean login(int id, String password) {
		Boolean isLogin = GenericDao.findOne(Account.class, "password", QueryFactory.EQUALS, password,
				QueryFactory.AND, "id", QueryFactory.EQUALS, id);
		return isLogin != null;
	}
	/**
	 * Tạo tài khoản
	 * @param acc dữ liệu về tài khoản
	 * @return
	 */
	public static boolean createAccount(Account acc) {
		return GenericDao.insert(acc);
	}
}
