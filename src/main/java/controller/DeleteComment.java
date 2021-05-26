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

@WebServlet(value = "/deletecomment")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public DeleteComment() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer commentId = Integer.parseInt(req.getParameter("commentId"));
		String blogId = req.getParameter("blogId");

		blogService.deleteComment(commentId);

		req.setAttribute("blog", blogService.getBlogDetail(blogId));
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogDetail.jsp");
		rdObj.include(req, resp);
	}
}
