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

@WebServlet(value = "/editpost")
public class EditPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BlogService blogService;

	public EditPost() {
		super();
		blogService = new BlogServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer postId = Integer.parseInt(req.getParameter("postId"));

		req.setAttribute("post", blogService.getPost(postId));
		RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/editpost.jsp");
		rdObj.include(req, resp);
	}
}
