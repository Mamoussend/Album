package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;
import form.UserForm;
import util.SessionManager;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private String path_regist="/WEB-INF/inscription.jsp";
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
		// TODO Auto-generated method stub
		String nom=request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String password_bis=request.getParameter("password_bis");
		String datnais=request.getParameter("datenais");
		System.out.println("date de naissance :" +datnais);


		Utilisateur user=new Utilisateur(nom, prenom, mail, password, datnais);
		System.out.println("user: "+user);
		if(user!=null & password.equals(password_bis) & UtilisateurDao.addUser(user)) {
			response.sendRedirect(request.getContextPath()+"/main");
		}
		else {
		response.sendRedirect(request.getContextPath()+"/inscription");	
		}
	}

}
