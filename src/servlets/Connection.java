package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;
import util.Hash;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/connection")
public class Connection extends HttpServlet {
	String path="/WEB-INF/Connection.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				String login= request.getParameter("login");
				String password=request.getParameter("password");
			   Utilisateur user = null;
			try {
				user = UtilisateurDao.UserMatch(login,Hash.passwordH(password));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(user!=null) {
					
					  HttpSession session = request.getSession();
						session.setAttribute("connected", true);
						session.setAttribute("id", user.getId());
						session.setAttribute("type", user.getType());
						session.setAttribute("nom", user.getNom());
						session.setAttribute("prenom", user.getPrenom());
						if("utilisateur".equals(user.getType())){
							response.sendRedirect(request.getContextPath()+"/user");
							System.out.println(request.getContextPath());
						}
						else {
							response.sendRedirect(request.getContextPath()+"/admin");
							System.out.println(request.getContextPath());
						}
						
				}
					
					else {
						response.sendRedirect(request.getContextPath()+"/connection");
						
					}
			
			}
	

}
