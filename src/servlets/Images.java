package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.Image;
import dao.ImageDao;
import util.SessionManager;

/**
 * Servlet implementation class Images
 */

@MultipartConfig( fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5,
maxRequestSize = 1024 * 1024 * 5 * 5 )
@WebServlet("/images")
public class Images extends HttpServlet {
       
		  public static final String IMAGES_FOLDER = "/Images";
		    String img="/WEB-INF/images.jsp";
		    public String uploadPath;
		    
		    private static final long serialVersionUID = 1273074928096412095L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
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


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			   HttpSession session=request.getSession();
				System.out.println("l id est :");
				String idf=(String) session.getAttribute("idalbum");
			// TODO Auto-generated method stub
			Map<String, String> param = new HashMap<>();
			String nomfi = null;
			boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
			if (!isMultipartContent) {
				System.out.println("no multipart");
				return;
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> fields = upload.parseRequest(request);
				Iterator<FileItem> it = fields.iterator();
				if (!it.hasNext()) {
					System.out.println("no data");
					return;
				}
				while (it.hasNext()) {
					System.out.println("data ok");
					FileItem fileItem = it.next();
					boolean isFormField = fileItem.isFormField();
					if (isFormField) {
						param.put(fileItem.getFieldName(), fileItem.getString());
					
					} else {
						if (fileItem.getSize() > 0) {
							 nomfi = fileItem.getName();
							
							
							//donner ici le chemin du repertoire du stockage des images
							fileItem.write(new File("/gesalbum/upload/" + fileItem.getName()));
							System.out.println("nomfi : "+nomfi );
							
						
						}
					}
				}
				String filename="/gesalbum/dossier/"+nomfi;
			String file="C:/Users/Mo...NDIAYE/dossier/"+nomfi;
				System.out.println(param.get("titre"));
				System.out.println(file);
				BufferedImage bimg = ImageIO.read(new File(file));
	    		int hauteur         = bimg.getWidth();
	    		int largeur         = bimg.getHeight();
	    		System.out.println("width: "+hauteur+",height: "+largeur);
				
				Image image= new Image(param.get("titre"), param.get("description"), hauteur,largeur, param.get("mots_cles"), filename,Integer.parseInt(idf));
				ImageDao.addImage(image);
				System.out.println("Nice ok bookc: ");
				response.sendRedirect(request.getContextPath());	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
}
