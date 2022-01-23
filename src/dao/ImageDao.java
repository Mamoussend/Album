package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import beans.Album;
import beans.Image;

public class ImageDao {

	public static boolean addImage(Image img) {

		boolean status=false;
		Connection connection=ConnexionManager.getConnection();	
						String req = "Insert INTO image(titre,description,hauteur,largeur,id_alb,chemin,date_creation,mots_cles) VALUES(?,?,?,?,?,?,?,?)";
				
				if(connection != null) {
					try {
						
						java.sql.PreparedStatement ps = connection.prepareStatement(req);
						ps.setString(1, img.getTitre());
						ps.setString(2, img.getDescription());
						ps.setLong(3, img.getHauteur());
						ps.setLong(4, img.getLargeur());
						ps.setInt(5, img.getIdalbum());
						ps.setString(6, img.getChemin());
						ps.setString(7, img.getDate_de_création());
						ps.setString(8, img.getMots_clés());
						

						ps.executeUpdate();
						status=true;
						
						System.out.println("Utilisateur ajout� avec succ�s !");
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
				
				return status;
			
		}
	
	
	public static  ArrayList<Image> listerImage() throws SQLException {
		
		ArrayList<Image>images=new ArrayList<Image>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM image";

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
					Image img=null;  
			  
					String titre=rs.getString("titre");
					String description =rs.getString("description");
					int hauteur=rs.getInt("hauteur");
					int largeur=rs.getInt("largeur");
					int idalbum =rs.getInt("id_alb");
					String chemin=rs.getString("chemin");
					String date_creation=rs.getString("date_creation");
					String date_maj=rs.getString("date_mis_jour");
					String mots_cles=rs.getString("mots_cles");
					
			        img=new Image(titre, description, hauteur, largeur, mots_cles, date_creation, chemin, idalbum, date_maj);
			      
			    	   
			    	  System.out.println(img);
			    	  images.add(img);
			    	 
			      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      return images; 
	        	  
	      }


	public static ArrayList<Image> listerImage(String ida) throws SQLException {
		int id=Integer.parseInt(ida);
		ArrayList<Image>images=new ArrayList<Image>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM image WHERE id_alb='" + id + "' " ;

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
					Image img=null;  
			  
					String titre=rs.getString("titre");
					String description =rs.getString("description");
					int hauteur=rs.getInt("hauteur");
					int largeur=rs.getInt("largeur");
					int idalbum =rs.getInt("id_alb");
					String chemin=rs.getString("chemin");
					String date_creation=rs.getString("date_creation");
					String date_maj=rs.getString("date_mis_jour");
					String mots_cles=rs.getString("mots_cles");
					
			        img=new Image(titre, description, hauteur, largeur, mots_cles, date_creation, chemin, idalbum, date_maj);
			      
			    	   
			    	  System.out.println(img);
			    	  images.add(img);
			    	 
			      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	      return images; 
	}
		
	
	public static  ArrayList<Image> listerImagepublic() throws SQLException {
		ArrayList<Album>alb=AlbumDao.listerAlbumpublic();
		ArrayList<Image>images=new ArrayList<Image>();
		Connection connection=ConnexionManager.getConnection();
		  // if you only need a few columns, specify them by name instead of using "*"
	for(Album album:alb)
	{
	      String query = "SELECT * FROM image WHERE id_alb='" + album.getIdproprietaire()+"'";
	      System.out.println("la requete est :" +query);

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
	      System.out.println();
	      // iterate through the java resultset
	 
			while (rs.next())
			  {
					Image img=null;  
			  
					String titre=rs.getString("titre");
					String description =rs.getString("description");
					int hauteur=rs.getInt("hauteur");
					int largeur=rs.getInt("largeur");
					int idalbum =rs.getInt("id_alb");
					String chemin=rs.getString("chemin");
					String date_creation=rs.getString("date_creation");
					String date_maj=rs.getString("date_mis_jour");
					String mots_cles=rs.getString("mots_cles");
					
			        img=new Image(titre, description, hauteur, largeur, mots_cles, date_creation, chemin, idalbum, date_maj);
			      
			    	   
			    	  System.out.println(img);
			    	  images.add(img);
			    	 
			      }     System.out.println("les images sont: "+images);
		
	  
	   
	}  
	   return images; 
	}
		
}
