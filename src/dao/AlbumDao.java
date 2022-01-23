package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Album;
import beans.Utilisateur;

public class AlbumDao {
	
	public AlbumDao() {
	
	}
	
public static boolean remove(int i) {
		
		boolean status=false;
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {

		    
			try {
				
				  
				PreparedStatement prepare=connection.prepareStatement("delete from  albums,image where id = ? and id_alb=?");
				
				prepare.setInt(1, i);
				prepare.setInt(2, i);
				
				
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

	public static boolean addAlbum(Album album) {
		String nom =album.getNom();
		String type=album.getType();
		String theme=album.getTheme();
		int idproprietaire=album.getIdproprietaire();
	
		
		
		boolean status=false;
		Connection connection=ConnexionManager.getConnection();
		if(connection!=null) {
			try {
				PreparedStatement prepare=connection.prepareStatement("Insert INTO albums(type,theme,proprietaire,nom) VALUES(?,?,?,?)");
				prepare.setString(1, type);
				prepare.setString(2, theme);
				prepare.setInt(3, idproprietaire);
				prepare.setString(4, nom);
			
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

	public static  ArrayList<Album> listerAlbum(int idp) throws SQLException {
	
		ArrayList<Album>albums=new ArrayList<Album>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM albums WHERE proprietaire='" + idp + "';";

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
	      try {
			while (rs.next())
			  {
					Album album=null;  
			  
				  String type = rs.getString("type");
			      String theme = rs.getString("theme");
			      
			      String nom = rs.getString("nom");
			        int id = rs.getInt("id_album");
			        album=new Album(nom, type, theme,id);
			      
			    	  album=new Album(nom, type, theme, id);  
			    	  System.out.println(album);
			    	  albums.add(album);
			    	 
			      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      return albums; 
	        	  
	      }
	public static void main(String[] args) {
		try {
			ArrayList< Album> a=listerAlbum(7);
			for(Album b:a) {
				System.out.println(b.getNom());
			}
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static  ArrayList<Album> listerAlbumpublic() throws SQLException {
		String types="public";
		ArrayList<Album>albums=new ArrayList<Album>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM albums WHERE type='" + types + "';";

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
	      try {
			while (rs.next())
			  {
					Album album=null;  
			  
				  String type = rs.getString("type");
			      String theme = rs.getString("theme");
			      
			      String nom = rs.getString("nom");
			        int id = rs.getInt("id_album");
			        album=new Album(nom, type, theme,id);
			      
			    	  album=new Album(nom, type, theme, id);  
			    	  System.out.println(album);
			    	  albums.add(album);
			    	 
			      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      return albums; 
	        	  
	      }
	public static  ArrayList<String> typeAlbum(int idp) throws SQLException {
		
		ArrayList<String>types=new ArrayList<String>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM albums WHERE id_album='" + idp + "';";

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
	      try {
			while (rs.next())
			  {
					Album album=null;  
			  
				  String type = rs.getString("type");
			 
			      
			    	   
			    	  System.out.println(type);
			    	  types.add(type);
			    	 
			      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      return types; 
	        	  
	      }
	     
}
