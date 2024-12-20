package services;

import java.util.List;

import dao.GenericDao;
import dao.QueryFactory;
import models.ProductType;
import models.Topic;

public class ProductService {
	public static List<Topic> getAllTopic() {
		return GenericDao.getAll(Topic.class);
	}

	public static List<ProductType> getTypes() {
		return GenericDao.findWithConditions(ProductType.class, "*", "parent",QueryFactory.IS_NULL);
	}
}
