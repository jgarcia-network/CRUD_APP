package CRUD_APP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	private final static String connectionString = "jdbc:mysql://localhost:3306/cars";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private static Connection connection;
	private static DBConnection instance;
	
	private DBConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				//System.out.println("Connection successful!");
				
		
			} catch (SQLException e) {
				System.out.println("Error connecting to database");
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}
}
