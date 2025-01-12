package dto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import models.AttributeKey;
import models.Brand;
import models.Product;
import models.ProductAttributes;
import models.ProductCategory;

public class FilterViewModel {
	private ProductCategory category;
	private List<ProductCategory> childrenCategory;
	private List<Brand> brands;
	private Brand brandSelected;
	private List<Integer> attributesSelected;
	private int totalQuantity;
	private List<Product> products;
	private Map<Integer, Map<Integer, Integer>> mappingAttributes;

	public String getAttributesSelected() {
		if (attributesSelected != null && !attributesSelected.isEmpty()) {
			StringBuilder build = new StringBuilder();
			for (Integer i : attributesSelected) {
				build.append(i).append(",");
			}
			build.deleteCharAt(build.length() - 1);
			System.out.println(build.toString());
			return build.toString();
		}
		return "";
	}

	public void setAttributesSelected(List<Integer> attributesSelected) {
		this.attributesSelected = attributesSelected;
	}

	public Map<AttributeKey, Map<ProductAttributes, List<Product>>> loadAttribute(List<Product> products) {
		Map<AttributeKey, Map<ProductAttributes, List<Product>>> mappingAttributes = new HashMap<>();
		for (Product product : products) {
			for (ProductAttributes at : product.getAttributes()) {
				Map<ProductAttributes, List<Product>> mappingQuantity = mappingAttributes.get(at.getAttributeKey());
				List<Product> quantity;
				if (mappingQuantity == null) {
					mappingQuantity = new HashMap<>();
					mappingAttributes.put(at.getAttributeKey(), mappingQuantity);
					quantity = new LinkedList<Product>();
				} else {
					quantity = mappingQuantity.get(at);
					if (quantity == null) {
						quantity = new LinkedList<Product>();
					}
				}
				quantity.add(product);
				mappingQuantity.put(at, quantity);
			}
		}
		return mappingAttributes;
	}

	public void setMappingAttributes() {
		mappingAttributes = new HashMap<>();
		for (Map.Entry<AttributeKey, Map<ProductAttributes, List<Product>>> entry : loadAttribute(products)
				.entrySet()) {
			AttributeKey key = entry.getKey();
			Map<ProductAttributes, List<Product>> val = entry.getValue();
			Map<Integer, Integer> temp = new HashMap<>();
			for (Map.Entry<ProductAttributes, List<Product>> e : val.entrySet()) {
				temp.put(e.getKey().getId(), e.getValue().size());
			}
			mappingAttributes.put(key.getId(), temp);
		}
	}

	public int getQuantity(int attributeId, int id) {
		try {
			return mappingAttributes.get(attributeId).get(id);
		} catch (NullPointerException e) {
			return 0;
		}

	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity += totalQuantity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void addProducts(List<Product> products) {
		if (this.products == null)
			this.products = new LinkedList<Product>();
		this.products.addAll(products);
	}

	public List<ProductCategory> getChildrenCategory() {
		return childrenCategory;
	}

	public void setChildrenCategory(List<ProductCategory> childrenCategory) {
		this.childrenCategory = childrenCategory;
	}

	public Brand getBrandSelected() {
		return brandSelected;
	}

	public void setBrandSelected(Brand brandSelected) {
		this.brandSelected = brandSelected;
	}

	public boolean isAttributeSelected(Integer attributeId) {
		return attributesSelected == null ? false : attributesSelected.contains(attributeId);
	}
}
