package services;

import java.util.List;

import dao.GenericDao;
import models.Account;
import models.AttributeKey;
import models.AttributeValue;
import models.Brand;
import models.OrderItem;
import models.Orders;
import models.Product;
import models.ProductAttributes;
import models.ProductCategory;
import models.Voucher;
import utils.QueryUtil;

public class AdminService {
	public static void setBan(Integer id, Boolean ban) {
		Account acc = AccountServices.getAccount(id);
		acc.setBan(ban);
		GenericDao.update(acc, true);
	}

	public static List<Account> getAllAccounts() {
		return GenericDao.getAll(Account.class);
	}

	public static List<Brand> getAllBrands() {
		return GenericDao.getAll(Brand.class);
	}

	public static List<Product> getAllProducts() {
		return GenericDao.getAll(Product.class);
	}

	public static List<ProductAttributes> getAllAttributes() {
		return GenericDao.getAll(ProductAttributes.class);
	}

	public static List<AttributeKey> getAllAttributeKeys() {
		return GenericDao.getAll(AttributeKey.class);
	}

	public static List<AttributeValue> getAllAttributeValues() {
		return GenericDao.getAll(AttributeValue.class);
	}

	public static List<ProductCategory> getAllCategories() {
		return GenericDao.getAll(ProductCategory.class);
	}
	public static List<Voucher> getAllVouchers() {
		return GenericDao.getAll(Voucher.class);
	}
	public static List<Orders> getAllOrders() {
		return GenericDao.getAll(Orders.class);
	}
	
	public static List<OrderItem> getAllOrderItem() {
		return GenericDao.getAll(OrderItem.class);
	}
	

	public static AttributeKey getAttributeKey(int id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(AttributeKey.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(AttributeKey.class, AttributeKey.class, query, id);
	}

	public static AttributeValue getAttributeValue(int id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(AttributeValue.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(AttributeValue.class, AttributeValue.class, query, id);
	}

	public static ProductCategory getCategory(int id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(ProductCategory.class, ProductCategory.class, query, id);
	}

	public static Brand getBrand(Integer id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Brand.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Brand.class, Brand.class, query, id);
	}

	public static void saveOrUpdateBrand(Brand brand) {
		if (brand.getId() == null)
			GenericDao.insert(brand, true);
		else
			GenericDao.update(brand, true);
	}

	public static void saveOrUpdateProduct(Product product) {
		if (product.getId() == null)
			GenericDao.insert(product, true);
		else
			GenericDao.update(product, true);
	}

	public static void saveOrUpdateAttributeValue(AttributeValue value) {
		if (value.getId() == null)
			GenericDao.insert(value, true);
		else
			GenericDao.update(value, true);
	}

	public static void saveOrUpdateAttributeKey(AttributeKey key) {
		if (key.getId() == null)
			GenericDao.insert(key, true);
		else
			GenericDao.update(key, true);
	}

	public static void saveOrUpdateCategory(ProductCategory category) {
		if (category.getId() == null)
			GenericDao.insert(category, true);
		else
			GenericDao.update(category, true);
	}
}
