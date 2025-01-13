package services;

import dao.GenericDao;
import models.Account;
import models.Product;
import models.Voucher;
import utils.AccountUtil;
import utils.QueryUtil;

public class VoucherService {
	public static Voucher findVoucher(Integer voucherId) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Voucher.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Voucher.class, Voucher.class, query, voucherId);
	}
	public static void saveOrUpdateVoucher(Voucher voucher) {
		if (voucher.getId() == null)
			GenericDao.insert(voucher, true);
		else
			GenericDao.update(voucher, true);
	}
	/**
	 * Kiểm tra mã voucher từ cơ sở dữ liệu.
	 * 
	 * @param voucherCode Mã voucher cần kiểm tra.
	 * @return Voucher nếu tìm thấy, null nếu không tìm thấy.
	 */
	public static Voucher checkVoucherCode(String voucherCode) {
		String condition = QueryUtil.createCondition("code", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Voucher.class, QueryUtil.ALL, condition);
		Voucher voucher = GenericDao.excuteQueryGetSingle(Voucher.class, Voucher.class, query, voucherCode);
		if (voucher != null) {
			return voucher;
		}
		return null;
	}

	/**
	 * Lấy giá trị % voucher
	 * 
	 */
	public static Double getDiscount(String voucherCode) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Voucher.class, QueryUtil.ALL, condition);
		Voucher voucher = GenericDao.excuteQueryGetSingle(Voucher.class, Voucher.class, query, voucherCode);
		return voucher.getPercentage();
	}
	public static boolean createVoucher(Voucher voucher) {
	    if (voucher == null) {
	        System.err.println("Voucher không được null khi tạo");
	        return false;
	    }
	    
	    if (GenericDao.insert(voucher, false)) {
	        GenericDao.commit(); 
	        return true;
	    }
	    
	    return false; 
	}

}
