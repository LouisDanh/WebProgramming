package controller.admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Product;
import models.ProductCategory;
import models.Topic;
import models.TopicCategory;
import models.id.TopicCategoryId;
import services.AdminService;

@WebServlet("/admin/topic/topic-detail")
public class TopicDetailAdminServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Topic topic = AdminService.getTopic(id);
		List<ProductCategory> categories = AdminService.getAllCategories();
		List<Product> products = AdminService.getAllProducts();
		req.setAttribute("topic", topic);
		req.setAttribute("availableCategories", categories);
		req.setAttribute("availableProducts", products);
		req.getRequestDispatcher("/views/admin/topicDetailView.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		Topic topic = AdminService.getTopic(Integer.parseInt(req.getParameter("topicId")));
		if ("addProduct".equals(action)) {

		} else if ("addCategory".equals(action)) {
			ProductCategory productCategory = AdminService
					.getCategory(Integer.parseInt(req.getParameter("categoryId").toString()));
			List<TopicCategory> categories = topic.getCategories();
			if (categories == null) {
				categories = new LinkedList<TopicCategory>();
				topic.setCategories(categories);
			}
			TopicCategory category = new TopicCategory();
			TopicCategoryId id = new TopicCategoryId();
			id.setCategoryId(productCategory.getId());
			id.setTopicId(topic.getId());
			category.setId(id);
			category.setTopic(topic);
			category.setCategory(productCategory);
			categories.add(category);
			AdminService.saveOrUpdateTopic(topic);
		}
		resp.sendRedirect("/WebMyPham/admin");
	}
}
