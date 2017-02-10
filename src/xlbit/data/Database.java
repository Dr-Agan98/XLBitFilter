package xlbit.data;

import java.sql.*;

public class Database {

	private Connection dtbConnection;
	private String URL = "jdbc:mysql://localhost:3306/";
	private Statement statement;
	private ResultSet resultSet;
	
	public Database(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Classe non trovata");
		}
	}
	
	public void newConnection(){
		try {
			dtbConnection = DriverManager.getConnection(URL+"xlbitdb","root","");
			statement = dtbConnection.createStatement();
		} catch (SQLException e) {
			System.out.println("Database Error Message: "+e.getMessage());
		}
	}
	
	public ResultSet executeQuery(String query){
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Error Message :"+e.getMessage());
		}
		
		return resultSet;
	}
	
	public void closeConnection(){
		try {
			statement.close();
			dtbConnection.close();
		} catch (SQLException e) {
			System.out.println("Error Message: "+e.getMessage());
		}
	}
	
}
