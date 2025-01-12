package services;

import java.util.List;

import dao.GenericDao;
import models.CartItem;
import models.OrderDetails;
import models.Orders;
import models.PaymentMethod;
import models.Product;
import models.ProductCategory;
import models.Topic;
import models.Voucher;
import utils.QueryUtil;

public class ProductService {
	public static List<Topic> getAllTopic() {
		return GenericDao.getAll(Topic.class);
	}

	public static Product findProduct(Integer idProduct) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Product.class, Product.class, query, idProduct);
	}

	public static List<ProductCategory> getChildCategory(Integer parentId) {
		String condition = QueryUtil.createCondition("parent.id",
				parentId == null ? QueryUtil.IS_NULL : QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetList(ProductCategory.class, ProductCategory.class, query, parentId);
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

	/**
	 * Lấy Orders
	 */
	public static List<Orders> getOrders(Integer cusId) {
		String condition = QueryUtil.createCondition("customer.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Orders.class, QueryUtil.ALL, condition);

		List<Orders> orders = GenericDao.excuteQueryGetList(Orders.class, Orders.class, query, cusId);
		return orders;
	}

	/**
	 * Lấy sản phẩm
	 */
	public static Product getProduct(Integer productIds) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, condition);
//		List<Product> products = GenericDao.excuteQueryGetList(Product.class, Product.class, query, productIds);
		return GenericDao.excuteQueryGetSingle(Product.class, Product.class, query, productIds);
	}

	public static List<CartItem> getCartItem(Integer cusId) {
		String condition = QueryUtil.createCondition("customer.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(CartItem.class, QueryUtil.ALL, condition);
		List<CartItem> cartItems = GenericDao.excuteQueryGetList(CartItem.class, CartItem.class, query, cusId);
		return cartItems;
	}

	

}
