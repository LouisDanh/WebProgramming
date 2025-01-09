package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Topic;
import services.ProductService;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Topic> topics = ProductService.getAllTopic();
		req.setAttribute("topics", topics);
		req.getRequestDispatcher("/views/home/home.jsp").forward(req, resp);
	}

}
