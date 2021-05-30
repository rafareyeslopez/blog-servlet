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

/**
 * Servlet para crear un nuevo blog.
 *
 */
@WebServlet(value = "/addblog")
public class AddBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public AddBlog() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		blogService.create(req.getParameter("name"), req.getParameter("url"),
				req.getSession().getAttribute("useremail").toString(), req.getParameterValues("categories"));

		// Anteriormente recogiamos
		// req.setAttribute("blogs",
		// blogService.getUserBlogs(req.getSession().getAttribute("useremail").toString()));
		req.setAttribute("blogs", blogService.getAllBlogs());
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogs.jsp");
		rdObj.include(req, resp);
	}
}
