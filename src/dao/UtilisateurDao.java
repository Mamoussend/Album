package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import util.Hash;

public class UtilisateurDao {
 
	 
	public UtilisateurDao() {
		// TODO Auto-generated constructor stub
	}
	public static boolean addUser(Utilisateur user) {
		String nom =user.getNom();
		String prenom=user.getPrenom();
		String mail=user.getMail();
		String password=Hash.passwordH(user.getPassword());
		String type=user.getType();
		String datenais=user.getDate_naiss();
		
		boolean status=false;
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {
			try {
				PreparedStatement prepare=connection.prepareStatement("Insert INTO utilisateur(prenom,nom,email,password,type,date_naiss) VALUES(?,?,?,?,?,?)");
				prepare.setString(1, prenom);
				prepare.setString(2, nom);
				prepare.setString(3, mail);
				prepare.setString(4, password);
				prepare.setString(5, type);
				prepare.setString(6,datenais);
				System.out.println("------------------------------------------------------------------------");
				System.out.println(prepare);
				System.out.println("------------------------------------------------------------------------");
				prepare.executeUpdate();
				connection.close();
				status= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return status;
	}
	public static Utilisateur UserMatch(String login,String password) throws SQLException {
	Utilisateur user=null;
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM utilisateur";

	      // create the java statement
	      Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	    	  String email = rs.getString("email");
	          String pass = rs.getString("password");
	          String prenom = rs.getString("prenom");
	          String nom = rs.getString("nom");
	            int id = rs.getInt("id");
	            String type= rs.getString("type");
	          System.out.println(email);
	          System.out.println(pass);
	          if(login.equals(email) && password.equals(pass)) {
	        	  user=new Utilisateur(nom, prenom, id,type);  
	        	  System.out.println(user);
	        	  return user;
	          }
	       
	        	 
	        	  
	      }
	      return user;
	}   
	public static 	ArrayList<Utilisateur> listUser() throws SQLException {
		ArrayList<Utilisateur> users= new  ArrayList<Utilisateur>();
		Utilisateur user=null;
			Connection connection=ConnexionManager.getConnection();
			  // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM utilisateur";

		      // create the java statement
		      Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		    	;
		          String prenom = rs.getString("prenom");
		          String nom = rs.getString("nom");
		            int id = rs.getInt("id");
		            String type= rs.getString("type");
		        
		        
		        	  user=new Utilisateur(nom, prenom, id,type);  
		             users.add(user);
		        	
		          
		       
		        	 
		        	  
		      }
		      System.out.println("La liste des users est: "+users);
		      return users;
		}
	public static boolean addpermission(List list, int id) {
	
		
		boolean status=false;
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {

		    
			try {
				for (int i = 0; i < list.size(); i++) {
				    int idp= Integer.parseInt((String) list.get(i));
				PreparedStatement prepare=connection.prepareStatement("Insert INTO permission(id_album,id_utilisateur) VALUES(?,?)");
				prepare.setInt(1, id);
				
				prepare.setInt(2, idp);
			
				System.out.println("------------------------------------------------------------------------");
				System.out.println(prepare);
				System.out.println("------------------------------------------------------------------------");
				
				prepare.executeUpdate();
			}
				connection.close();
				status= true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		return status;
	}
	public static boolean remove(int i) {
		
		boolean status=false;
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {

		    
			try {
				
				  
				PreparedStatement prepare=connection.prepareStatement("delete from  utilisateur where id = ?");
				prepare.setInt(1, i);
				
				
				System.out.println("------------------------------------------------------------------------");
				System.out.println(prepare);
				System.out.println("------------------------------------------------------------------------");
				
				prepare.executeUpdate();
		
				connection.close();
				System.out.println("checked me bro!!!!!!");
				status= true;
				
			} catch (SQLException e) {
				System.err.println("Got an exception! ");
			      System.err.println(e.getMessage());
			}
	
		}
		return status;
		}
	public static Utilisateur getUser(int ids) throws SQLException {

		Utilisateur user=null;
			Connection connection=ConnexionManager.getConnection();
			  // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM utilisateur WHERE id='"+ids+"'";

		      // create the java statement
		      Statement st = null;
			try {
				st = connection.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		    	;
		    	  String mail = rs.getString("email");
		          String pass = rs.getString("password");
		          String prenom = rs.getString("prenom");
		          String nom = rs.getString("nom");
		          String type= rs.getString("type");
		          String  date_naiss= rs.getString("date_naiss");
		          String  password=rs.getString("password");
		          int id = rs.getInt("id");
		        
		      user=new Utilisateur(nom, prenom, mail,  password, date_naiss,  type, id);  
		         
		        	
		          
		       
		        	 
		        	  
		      }
		      System.out.println("La liste des users est: "+user);
		      return user;
	}
		
	   
	public static boolean modifier(Utilisateur user,int ids) throws SQLException{
		boolean status=false;
		String nom =user.getNom();
		String prenom=user.getPrenom();
		String mail=user.getMail();
		String password=Hash.passwordH(user.getPassword());
		String type=user.getType();
		String datenais=user.getDate_naiss();
		
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {
			try {
				PreparedStatement prepare=connection.prepareStatement("UPDATE utilisateur SET prenom=?,nom=?,email=?,password=?,type=?,date_naiss=? WHERE id = ? ");
				System.out.println("sql: "+prepare);
				prepare.setString(1, prenom);
				prepare.setString(2, nom);
				prepare.setString(3, mail);
				prepare.setString(4, password);
				prepare.setString(5, type);
				prepare.setString(6,datenais);
				prepare.setInt(7,ids);
				System.out.println("------------------------------------------------------------------------");
				System.out.println(prepare);
				System.out.println("------------------------------------------------------------------------");
				prepare.executeUpdate();
				connection.close();
				status= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("status : "+status);
		return status;	
	}

	

}
