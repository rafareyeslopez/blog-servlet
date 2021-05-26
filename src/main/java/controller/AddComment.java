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

@WebServlet(value = "/addcomment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public AddComment() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String blogId = req.getParameter("blogId");

		blogService.addComment(Integer.parseInt(req.getParameter("postId")), req.getParameter("content"),
				req.getParameter("user"));

		req.setAttribute("blog", blogService.getBlogDetail(blogId));
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogDetail.jsp");
		rdObj.include(req, resp);
	}
}
