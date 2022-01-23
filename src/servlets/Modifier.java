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
import form.UserForm;
import util.SessionManager;

/**
 * Servlet implementation class Modifier
 */
@WebServlet("/modifier")
public class Modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		if (SessionManager.checkSession(request.getSession())) {
	     HttpSession session=request.getSession();
	     if(request.getParameter("id")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("iddelect", id);
			System.out.println("les id sont :"+id);
		//	request.setAttribute("id", id);
			Utilisateur user = null;
			
			try {
				user = UtilisateurDao.getUser(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("user", user);
	     }
			

		getServletContext().getRequestDispatcher("/WEB-INF/modif.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     HttpSession session=request.getSession();
	     int i=(int) session.getAttribute("iddelect");
		String nom=request.getParameter("nom");
		String prenom= request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String password_bis=request.getParameter("password_bis");
		String datnais=request.getParameter("datnais");
		System.out.println("date de naissance :" +datnais);
		String type=request.getParameter("type");

		Utilisateur user=new Utilisateur(nom, prenom, mail, password, datnais,type,i);
		System.out.println("user: "+user);
		try {
			if(user!=null & password.equals(password_bis) & UtilisateurDao.modifier(user, user.getId())) {
				response.sendRedirect(request.getContextPath()+"/main");
				try {
					UtilisateurDao.modifier(user, user.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
			response.sendRedirect(request.getContextPath()+"/modifier");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
