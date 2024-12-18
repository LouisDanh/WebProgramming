package services;

import dao.GenericDao;

public class AccountServices {
	/**
	 * Lấy id tài khoản từ thông tin email
	 * 
	 * @param email
	 * @return id nếu tồn tại, ngược lại null
	 */
	public Integer getIdAccount(String email) {
		return GenericDao.findOne("=", Integer.class.getName(), "email", email);
	}

	public boolean login(int id,String password) {
		return GenericDao.findOne("", password, null);
	}
}
