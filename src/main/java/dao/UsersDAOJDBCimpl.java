package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAOJDBCimpl implements UsersDAO {
	@Override
	public void register(User user) {
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("insert into users (email,password, name,last_name) values (?,?,?,?)");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getLastName());
			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		try {
			Connection conn = Database.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from Users where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new User(rs.getString("email"), rs.getString("password"), rs.getString("name"),
						rs.getString("last_name"));
			}

			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return user;
	}

}
