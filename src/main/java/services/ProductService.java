package services;

import dao.GenericDao;
import models.Product;
import java.util.List;

public class ProductService {

    private static final String CLASS_NAME = Product.class.getName(); 

    /**
     * Lấy tất cả sản phẩm
     * 
     * @return Danh sách các sản phẩm
     */
    public List<Product> getAllProducts() {
        return GenericDao.getAll(CLASS_NAME); 
    }
    
    
    

}