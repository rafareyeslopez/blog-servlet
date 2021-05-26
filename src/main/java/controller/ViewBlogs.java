package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BlogService;
import service.BlogServiceImpl;

@WebServlet(value = "/viewBlogs")
public class ViewBlogs extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BlogService blogService;

	public ViewBlogs() {
		super();
		blogService = new BlogServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("blogs", blogService.getAllBlogs());
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogs.jsp");
		rdObj.include(req, resp);

	}
}
