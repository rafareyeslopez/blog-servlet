package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Md5;
import service.UsersService;
import service.UsersServiceImpl;

@WebServlet(value = "/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersService service = new UsersServiceImpl();

		service.register(req.getParameter("user"), Md5.ConvertToMd5(req.getParameter("password")),
				req.getParameter("fname"), req.getParameter("lname"));

		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}
}
