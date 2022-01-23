package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;
import form.UserForm;

/**
 * Servlet implementation class addadmin
 */
@WebServlet("/addadmin")
public class addadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private String path_regist="/WEB-INF/addadmin.jsp";
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			// TODO Auto-generated method stub
					
						this.getServletContext().getRequestDispatcher(path_regist).forward(request, response);
					
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom=request.getParameter("nom");
		String type=request.getParameter("type");
		String prenom= request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String password_bis=request.getParameter("password_bis");
		String datnais=request.getParameter("datenais");
		Utilisateur user=new Utilisateur(nom, prenom, mail, password, datnais,type);
		
		if((password.equals(password_bis)) & UtilisateurDao.addUser(user)) {
			response.sendRedirect(request.getContextPath()+"/admin");
		}
		else {
		response.sendRedirect(request.getContextPath()+"/addadmin");	
		}
	
	}

}
