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
import models.Voucher;
import services.ProductService;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] productIds = req.getParameterValues("productId");

		if (productIds != null) {
			List<CartItem> cartItems = new ArrayList<>();

			for (String productIdStr : productIds) {
				try {
					int productId = Integer.parseInt(productIdStr);

					Product product = ProductService.findProduct(productId);
					if (product != null) {
						// Tạo CartItem
						CartItem cartItem = new CartItem();
						cartItem.setProduct(product);
						cartItem.setQuantity(1);
						cartItems.add(cartItem);
					}
				} catch (NumberFormatException e) {
					resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID: " + productIdStr);
					return;
				}
			}
			req.setAttribute("cartItems", cartItems);
			req.getRequestDispatcher("views/home/cart.jsp").forward(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Không có sản phẩm nào trong giỏ hàng");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productIdStr = req.getParameter("productId");
		if (productIdStr != null) {
			try {
				int productId = Integer.parseInt(productIdStr);

				// Lấy giỏ hàng từ session
				List<CartItem> cartItems = (List<CartItem>) req.getSession().getAttribute("cartItem");

				if (cartItems != null) {
					boolean found = false;
					for (CartItem cartItem : cartItems) {
						if (cartItem.getProduct().getId() == productId) {
							// Tăng số lượng sản phẩm
							cartItem.setQuantity(cartItem.getQuantity() + 1);
							found = true;
							break;
						}
					}
					if (!found) {
						// Nếu sản phẩm không có trong giỏ hàng, thêm mới vào giỏ
						Product product = ProductService.findProduct(productId);
						if (product != null) {
							CartItem newCartItem = new CartItem();
							newCartItem.setProduct(product);
							newCartItem.setQuantity(1);
							cartItems.add(newCartItem);
						}
					}
				}

				// Lưu lại giỏ hàng vào session
				req.getSession().setAttribute("cartItems", cartItems);

				// Redirect hoặc forward lại để hiển thị giỏ hàng
				resp.sendRedirect("cart.jsp");

			} catch (NumberFormatException e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product ID");
			}
		} else {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is required");
		}
	}
}