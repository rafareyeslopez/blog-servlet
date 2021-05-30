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

@WebServlet(value = "/addpost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public AddPost() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		blogService.addPost(req.getParameter("title"), req.getParameter("content"),
				Integer.parseInt(req.getParameter("blogId")));

		req.setAttribute("blog", blogService.getBlogDetail(req.getParameter("blogId")));
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogDetail.jsp");
		rdObj.include(req, resp);
	}
}
