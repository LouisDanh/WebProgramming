package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FilterViewModel;
import models.Brand;
import models.Product;
import models.ProductCategory;
import services.ProductService;

@WebServlet("/home/product/category")
public class CategoryProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer id = null;
			Integer parentId = Integer.parseInt(req.getSession().getAttribute("parentId").toString());
			try {
				id = Integer.parseInt(req.getParameter("id"));
			} catch (NumberFormatException e) {
				id = parentId;
			}
			FilterViewModel model = new FilterViewModel();
			ProductCategory category = ProductService.getCategory(id);
			ProductCategory parentCategory = ProductService.getCategory(parentId);
			model.setCategory(category);
			model.setChildrenCategory(parentCategory.getChildren());
			List<Product> products = ProductService.getProductByCategory(id);
			List<Brand> brands = ProductService.getAllBrandsByCategory(id);
			model.setProducts(products);
			model.setTotalQuantity(products.size());
			model.setBrands(brands);
			model.setMappingAttributes();
			req.setAttribute("filter", model);
			req.getRequestDispatcher("/views/home/listProductCategory.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			resp.sendRedirect("/home");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer brandId = null, categoryId = null;
		Integer[] attributesId = null;
		FilterViewModel model = new FilterViewModel();
		try {
			brandId = Integer.parseInt(req.getParameter("brandId").toString());
		} catch (NumberFormatException e) {
		}
		try {
			categoryId = Integer.parseInt(req.getParameter("categoryId").toString());
		} catch (NumberFormatException e) {
		}
		StringTokenizer attributesIdString = new StringTokenizer(req.getParameter("attributesId"), ",");
		if (attributesIdString != null && attributesIdString.countTokens() > 0) {
			attributesId = new Integer[attributesIdString.countTokens()];
			try {
				int i = 0;
				while (attributesIdString.hasMoreTokens()) {
					attributesId[i++] = Integer.parseInt(attributesIdString.nextToken());
				}
				model.setAttributesSelected(Arrays.asList(attributesId));
			} catch (NumberFormatException e) {
				attributesId = null;
			}
		}
		List<Product> products = ProductService.getProductByFilter(categoryId, brandId, attributesId);
		List<Brand> brands = ProductService.getBrandsByCategory(categoryId);
		ProductCategory category = ProductService.getCategory(categoryId);
		ProductCategory parentCategory = ProductService
				.getCategory(Integer.parseInt(req.getSession().getAttribute("parentId").toString()));
		Brand brandSelected = null;
		if (brandId != null)
			for (Brand brand : brands) {
				if (brand.getId() == brandId) {
					brandSelected = brand;
				}
			}
		model.setBrandSelected(brandSelected);
		model.setProducts(products);
		model.setTotalQuantity(products.size());
		model.setBrands(brands);
		model.setMappingAttributes();
		model.setCategory(category);
		model.setChildrenCategory(parentCategory.getChildren());
		req.setAttribute("filter", model);
		req.getRequestDispatcher("/views/home/listProductCategory.jsp").forward(req, resp);
	}
}
