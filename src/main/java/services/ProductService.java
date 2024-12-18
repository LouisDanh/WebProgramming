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

    /**
     * Thêm một sản phẩm mới
     * 
     * @param product Sản phẩm cần thêm
     * @return true nếu thêm thành công, false nếu thất bại
     */
    public boolean addProduct(Product product) {
        return GenericDao.insert(product);
    }

    /**
     * Cập nhật thông tin sản phẩm
     * 
     * @param product Sản phẩm cần cập nhật
     * @return true nếu cập nhật thành công, false nếu thất bại
     */
    public boolean updateProduct(Product product) {
        return GenericDao.update(product); 
    }

    /**
     * Tìm kiếm sản phẩm theo điều kiện AND
     * 
     * @param operator Toán tử tìm kiếm (ví dụ: "=", "LIKE")
     * @param datas Các điều kiện tìm kiếm dưới dạng key-value
     * @return Danh sách các sản phẩm tìm thấy
     */
    public List<Product> findProductsByConditionAnd(String operator, Object... datas) {
        return GenericDao.findAnd(operator, CLASS_NAME, datas); 
    }

    /**
     * Tìm kiếm sản phẩm theo điều kiện OR
     * 
     * @param operator Toán tử tìm kiếm (ví dụ: "=", "LIKE")
     * @param datas Các điều kiện tìm kiếm dưới dạng key-value
     * @return Danh sách các sản phẩm tìm thấy
     */
    public List<Product> findProductsByConditionOr(String operator, Object... datas) {
        return GenericDao.findOr(operator, CLASS_NAME, datas); // Gọi phương thức GenericDao để tìm kiếm sản phẩm theo OR
    }

    /**
     * Tìm một sản phẩm duy nhất theo điều kiện
     * 
     * @param operator Toán tử tìm kiếm (ví dụ: "=", "LIKE")
     * @param datas Các điều kiện tìm kiếm dưới dạng key-value
     * @return Sản phẩm tìm thấy, nếu không có thì trả về null
     */
    public Product findProductByCondition(String operator, Object... datas) {
        return GenericDao.findOne(operator, CLASS_NAME, datas); // Gọi phương thức GenericDao để tìm một sản phẩm duy nhất
    }
}
