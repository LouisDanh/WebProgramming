package controller.admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductViewModel;
import models.Gallery;
import models.Product;
import models.ProductAttributes;
import services.AdminService;
import services.ProductService;
import utils.UploadUtils;

@MultipartConfig(maxFileSize = 10485760, maxRequestSize = 20971520, fileSizeThreshold = 0)
@WebServlet("/admin/product")
public class ProductAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = null;
		try {
			product = ProductService.findProduct(Integer.parseInt(req.getParameter("id")));
		} catch (NumberFormatException e) {
		}
		req.setAttribute("productViewModel", new ProductViewModel(product, AdminService.getAllBrands(),
				AdminService.getAllCategories(), AdminService.getAllAttributes()));
		req.getRequestDispatcher("/views/admin/productView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		String stockStr = request.getParameter("stock");
		String discountStr = request.getParameter("discount");
		String description = request.getParameter("description");
		String categoryIdStr = request.getParameter("categoryId");
		String brandIdStr = request.getParameter("brandId");
		String[] attributesStr = request.getParameterValues("attributes");
		List<String> path = UploadUtils.uploadImg(request.getParts(),
				"D:\\Programming\\Project\\Web\\UngDungWebBanMyPham_Hishaku\\src\\main\\webapp\\resources\\static\\img\\products");
		int id = Integer.parseInt(idStr);
		double price = Double.parseDouble(priceStr);
		int stock = Integer.parseInt(stockStr);
		double discount = Double.parseDouble(discountStr);
		int categoryId = Integer.parseInt(categoryIdStr);
		int brandId = Integer.parseInt(brandIdStr);
		Product product = id == -1 ? new Product() : ProductService.findProduct(id);
		List<Gallery> galleries = id == -1 ? new LinkedList<Gallery>() : product.getGalleries();
		for (String str : path) {
			Gallery gallery = new Gallery();
			gallery.setLink(str);
			gallery.setType("img");
			galleries.add(gallery);
		}
		List<ProductAttributes> attributes = id == -1 ? new LinkedList<ProductAttributes>() : product.getAttributes();
		for (String str : attributesStr) {
			StringTokenizer tokens = new StringTokenizer(str, ",");
			Integer key = Integer.parseInt(tokens.nextToken());
			Integer value = Integer.parseInt(tokens.nextToken());
			if (!product.sameAttribute(key, value))
				attributes.add(new ProductAttributes(AdminService.getAttributeKey(key),
						AdminService.getAttributeValue(value)));
		}
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setDiscount(discount);
		product.setDescription(description);
		product.setCategory(ProductService.getCategory(categoryId));
		product.setBrand(ProductService.getBrand(brandId));
		product.setAttributes(attributes);
		product.setGalleries(galleries);
		AdminService.saveOrUpdateProduct(product);
		resp.sendRedirect("/WebMyPham/admin");
	}
}
