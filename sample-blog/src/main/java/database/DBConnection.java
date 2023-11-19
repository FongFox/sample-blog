package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			// Đăng ký mysql với DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			// Các thông số
			String url = "jdbc:mySQL://localhost:3306/sample_blog";
			String username = "admin";
			String password = "admin";

			// Tạo kết nối
			connection = DriverManager.getConnection(url, username, password);

			// In kết quả
			System.out.println("Connect Complete!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
				System.out.println("Close Connection Complete !!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
