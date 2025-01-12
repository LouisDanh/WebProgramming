package dto;

import java.util.ArrayList;
import java.util.List;

import models.AttributeKey;
import models.AttributeValue;
import models.Brand;
import models.Product;
import models.ProductAttributes;
import models.ProductCategory;

public class ProductViewModel {

	private Product product;
	private List<Brand> brands;
	private List<ProductCategory> categories;
	private List<ProductAttributes> productAttributes;

	// Constructor
	public ProductViewModel(Product product, List<Brand> brands, List<ProductCategory> categories,
			List<ProductAttributes> productAttributes) {
		this.product = product;
		this.brands = brands;
		this.categories = categories;
		this.productAttributes = productAttributes;
	}

	public ProductViewModel(List<ProductAttributes> productAttributes) {
		this.productAttributes = productAttributes;
	}

	// Getters and Setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public List<ProductCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ProductCategory> categories) {
		this.categories = categories;
	}

	public List<ProductAttributes> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(List<ProductAttributes> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public List<AttributeKey> getAttributeKeys() {
	    List<AttributeKey> attributeKeys = new ArrayList<>();
	    for (ProductAttributes pa : productAttributes) {
	        AttributeKey key = pa.getAttributeKey();
	        if (!attributeKeys.contains(key)) {
	            attributeKeys.add(key);
	        }
	    }
	    return attributeKeys;
	}

	public List<AttributeValue> getAttributeValuesByKey(AttributeKey key) {
	    List<AttributeValue> attributeValues = new ArrayList<>();
	    for (ProductAttributes pa : productAttributes) {
	        if (pa.getAttributeKey().equals(key) && !attributeValues.contains(pa.getAttValue())) {
	            attributeValues.add(pa.getAttValue());
	        }
	    }
	    return attributeValues;
	}


}
