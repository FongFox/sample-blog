package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBExecution {

	public static void executeStatement(String sqlStatement) {
		try {
			Connection connection = DBConnection.getConnection();

			Statement statement = connection.createStatement();

			statement.execute(sqlStatement);

			System.out.println("execute complete!!!");

			DBConnection.closeConnection(connection);
		} catch (SQLException sql) {
			System.out.println(sql);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public static void executeStatements(String sqlStatements[]) {
		try {
			Connection connection = DBConnection.getConnection();

			Statement statement = connection.createStatement();

			for (int i = 0; i < sqlStatements.length; i++) {
				try {
					statement.execute(sqlStatements[i]);
					System.out.println("execute " + i + " complete!!!");
				} catch (SQLException ex) {
					Logger.getLogger(DBExecution.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

			DBConnection.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
