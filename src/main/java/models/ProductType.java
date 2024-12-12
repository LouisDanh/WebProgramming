package models;

import java.util.List;

public class ProductType {
	private int id;
	private ProductType parent;
	private List<ProductType> child;
	private String name;
	private String decription;
	private List<Product>products;
	private boolean state;
}
