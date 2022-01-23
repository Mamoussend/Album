package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import beans.Image;
import dao.ImageDao;
import util.SessionManager;






/*
 * Notre serlvet permettant de récupérer les fichiers côté serveur.
 * Elle répondra à l'URL /upload dans l'application Web considérée.
 */

@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
                  maxFileSize = 1024 * 1024 * 5,
                  maxRequestSize = 1024 * 1024 * 5 * 5 )
@WebServlet("/img")
public class Img extends HttpServlet {
    private static final long serialVersionUID = 1273074928096412095L;
    
    /*
     * Chemin dans lequel les images seront sauvegardées.
     */
    public static final String IMAGES_FOLDER = "/Images";
    String img="/WEB-INF/img.jsp";
    public String uploadPath;
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Img() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionManager.checkSession(request.getSession())) {
               HttpSession session=request.getSession();
           
			System.out.println("l'id est de : ");
			String idalbum=(String) request.getParameter("idal");
		    session.setAttribute("idalbum", idalbum);;
			System.out.println("l'id est de : "+idalbum);
			getServletContext().getRequestDispatcher(img).forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);	
		}
	}


    
    /** Si le dossier de sauvegarde de l'image n'existe pas, on demande sa création.**/
    @Override
    public void init() throws ServletException {
        uploadPath = "C:/Users/Mo...NDIAYE/Documents/Prod_jee/gesalbum/Images";
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();
    }
	 

	
	/* * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   HttpSession session=request.getSession();
		System.out.println("l id est :");
		String idf=(String) session.getAttribute("idalbum");
		System.out.println("l id est : "+idf);
		// TODO Auto-generated method stub
		        for ( Part part : request.getParts() ) {
		            String fileName = getFileName( part );
		            String fullPath = uploadPath + "/" + fileName;
		            System.out.println("uploadfile: "+fullPath);
		            part.write( fullPath );
		            System.out.println("uploadfile2: "+fullPath);
		            try
		    		{
		                System.out.println("uploadfile2: "+fullPath);
		    		FileOutputStream fos=new FileOutputStream(fullPath);
		    	      System.out.println("uploadfile2: "+fullPath);
		    		InputStream is=part.getInputStream();
		    	      System.out.println("uploadfile2: "+fullPath);
		    		
		    		byte[] data=new byte[is.available()];
		    		is.read(data);
		    		fos.write(data);
		    		
		    		fos.close();
		    		BufferedImage bimg = ImageIO.read(new File(fullPath));
		    		int width          = bimg.getWidth();
		    		int height         = bimg.getHeight();
		    		System.out.println("width: "+width+",height: "+height);
		    		String titre=fileName;
		    		String mot_cles=fileName+",idalbum";
		    		String description=fileName+",idalbum";
		         	String chemin = "/gesalbum/dossier/"+fileName;
		    		Image img= new Image(titre, description, width,height, mot_cles,chemin,Integer.parseInt(idf));
		    	          ImageDao.addImage(img);
		    		}
		    		
		    		catch(Exception e)
		    		{
		    			e.printStackTrace();
		    		}
		        }
		    }

		    /*
		     * Récupération du nom du fichier dans la requête.
		     */
		    private String getFileName( Part part ) {
		    	 System.out.println("part:" +part);
		        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
		            if ( content.trim().startsWith( "filename" ) )
		                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
		        }
		        return "Default.file";
		    }
	  

}
