package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.AttributeKey;
import models.AttributeValue;
import models.Brand;
import models.OrderItem;
import models.Orders;
import models.Product;
import models.ProductCategory;
import models.Topic;
import models.Voucher;
import services.AdminService;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Brand> brands = AdminService.getAllBrands();
		List<ProductCategory> categories = AdminService.getAllCategories();
		List<Account> accounts = AdminService.getAllAccounts();
		List<Product> products = AdminService.getAllProducts();
		List<AttributeValue> attributeValues = AdminService.getAllAttributeValues();
		List<AttributeKey> attributeKeys = AdminService.getAllAttributeKeys();
		List<Topic> topics = AdminService.getAllTopics();
		req.setAttribute("topics", topics);
		List<Voucher> vouchers = AdminService.getAllVouchers();
		List<Orders> orders = AdminService.getAllOrders();
		List<OrderItem> orderItems = AdminService.getAllOrderItem();
		req.setAttribute("brands", brands);
		req.setAttribute("categories", categories);
		req.setAttribute("attributeKeys", attributeKeys);
		req.setAttribute("attributeValues", attributeValues);
		req.setAttribute("accounts", accounts);
		req.setAttribute("products", products);
		req.setAttribute("vouchers", vouchers);
		req.setAttribute("orders", orders);
		req.setAttribute("orderItems", orderItems);

		req.getRequestDispatcher("/views/admin/index.jsp").forward(req, resp);
	}
}
