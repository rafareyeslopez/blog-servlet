package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	private static final String DB_PATH = "C:\\Users\\rafar\\eclipse-workspace\\blog-servlet\\sqllite\\blog.db";

	private static Connection connection;

	static Connection getConnection() {
		try {
			String url = "jdbc:sqlite:" + DB_PATH;
			if (connection == null) {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection(url);
			}
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
