package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Album;
import dao.AlbumDao;
import dao.UtilisateurDao;
import util.SessionManager;

/**
 * Servlet implementation class Addalbum
 */
@WebServlet("/addalbum")
public class Addalbum extends HttpServlet {
	private static String addalbum="/WEB-INF/addalbum.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (SessionManager.checkSession(request.getSession())) {
			getServletContext().getRequestDispatcher(addalbum).forward(request, response);
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
		HttpSession session = request.getSession();
	    int id=(int) session.getAttribute("id");
		String nom=request.getParameter("nom");
		String type=request.getParameter("type");
		String theme=request.getParameter("theme");
		Album album=new Album(nom, type, theme, id);
		if(AlbumDao.addAlbum(album)) {
			response.sendRedirect(request.getContextPath()+"/user");
		}else
			response.sendRedirect(request.getContextPath()+"/addalbum");
	}

}
