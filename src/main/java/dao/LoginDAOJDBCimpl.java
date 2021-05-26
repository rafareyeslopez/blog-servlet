package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAOJDBCimpl implements LoginDAO {

	@Override
	public boolean login(String email, String password) {
		boolean status = false;
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return status;
	}

	@Override
	public User getUser(String name, String password) {
		User user = null;
		String email = "";
		String pass = "";
		String fname = "";
		String lname = "";
		try {

			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Users where email=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				email = rs.getString(1);
				pass = rs.getString(2);
				fname = rs.getString(3);
				lname = rs.getString(4);
			}
			user = new User(email, pass, fname, lname);
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return user;
	}
}
