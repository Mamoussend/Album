package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlbumDao;
import dao.UtilisateurDao;
import util.SessionManager;

/**
 * Servlet implementation class listUsers
 */
@WebServlet("/listUsers")
public class listUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String user="/WEB-INF/listuser.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  if (SessionManager.checkSession(request.getSession())) {
			   HttpSession session=request.getSession();
				  int id= (int) session.getAttribute("id");
				  System.out.println(id);
				
			
			try {
				request.setAttribute("user", UtilisateurDao.listUser());
				getServletContext().getRequestDispatcher(user).forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  }
			else {
				getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);	
			}
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
