package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logout")
public class LogoutUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LogoutUser() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("useremail");

		RequestDispatcher rdObj = req.getRequestDispatcher("/index.jsp");
		rdObj.include(req, resp);

	}
}
