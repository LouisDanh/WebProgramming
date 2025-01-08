package services;

import java.util.List;

import dao.GenericDao;
import models.Product;
import models.ProductCategory;
import models.Topic;
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

}
