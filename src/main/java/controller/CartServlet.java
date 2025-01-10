package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.CartItem;
import models.Product;
import services.ProductService;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private ProductService productService;

	@Override
	public void init() throws ServletException {
		productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] productIds = req.getParameterValues("productId");

		if (productIds != null) {
			List<CartItem> cartItems = new ArrayList<>();

			for (String productIdStr : productIds) {
				int productId = Integer.parseInt(productIdStr);

				Product product = productService.findProduct(productId);
				if (product != null) {
					// Tạo CartItem cho mỗi sản phẩm
					CartItem cartItem = new CartItem();
					cartItem.setProduct(product);
					cartItem.setQuantity(1);
					cartItems.add(cartItem);
				}
			}
			req.setAttribute("cartItems", cartItems);
			req.getRequestDispatcher("views/home/cart.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("views/home/cart.jsp");
//			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không có sản phẩm nào trong giỏ hàng");
		}
	}

}
