package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BlogService;
import service.BlogServiceImpl;
import service.UsersService;
import service.UsersServiceImpl;

@WebServlet(value = "/login")
public class LoginUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsersService userService;
	private BlogService blogService;

	public LoginUser() {
		super();
		userService = new UsersServiceImpl();
		blogService = new BlogServiceImpl();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (userService.login(email, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("useremail", email);

			// req.setAttribute("blogs", blogService.getUserBlogs(email));
			req.setAttribute("blogs", blogService.getAllBlogs());
			RequestDispatcher rdObj = req.getRequestDispatcher("/jsp/blogs.jsp");
			rdObj.include(req, resp);

		} else {
			String message = "Invalid email/password";
			req.setAttribute("message", message);
			RequestDispatcher rdObj = req.getRequestDispatcher("/index.jsp");
			rdObj.include(req, resp);
		}

//				{
//			if (dao.login(e, p)) {
//				User user = dao.getUser(e, p);
//				HttpSession session = req.getSession();
//				session.setAttribute("user", user);
//				destServ = "/notas";
//
//			} else {
//				String message = "Invalid email/password";
//				req.setAttribute("message", message);
//			}
//		}
//		resp.sendRedirect(destServ);
	}
}
