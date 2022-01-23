package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {

	public ConnexionManager() {
		// TODO Auto-generated constructor stub
	}
	private static String Db_url="jdbc:mysql://localhost/album";
	private  static String Db_user="root";
	private static String Db_password="";
	static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(Db_url,Db_user,Db_password);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		   System.out.println("Erreur de chargement du pilote "+e.getMessage()); 
		} catch (SQLException e) {
			 System.out.println("Erreur de connection "+e.getMessage()); 
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		Connection connection=getConnection();
		System.out.println(connection);
		System.out.println("Succes");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
