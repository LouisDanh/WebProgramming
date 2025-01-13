package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductViewModel;
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
import services.AdminService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = AdminService.getAllBrands();
		List<ProductCategory> categories = AdminService.getAllCategories();
		List<ProductAttributes> proAttribute = AdminService.getAllAttributes();
		List<Account> accounts = AdminService.getAllAccounts();
		List<Product> products = AdminService.getAllProducts();
		List<Voucher> vouchers = AdminService.getAllVouchers();
		List<Orders> orders = AdminService.getAllOrders();
		List<OrderItem> orderItems = AdminService.getAllOrderItem();
		Map<AttributeKey, List<AttributeValue>> attributes = new HashMap<>();
		ProductViewModel model = new ProductViewModel(proAttribute);
		for (AttributeKey key : model.getAttributeKeys()) {
			attributes.put(key, model.getAttributeValuesByKey(key));
		}
		req.setAttribute("brands", brands);
		req.setAttribute("categories", categories);
		req.setAttribute("attributes", attributes);
		req.setAttribute("accounts", accounts);
		req.setAttribute("products", products);
		req.setAttribute("vouchers", vouchers);
		req.setAttribute("orders", orders);
		req.setAttribute("orderItems", orderItems);

		req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
	}
}
