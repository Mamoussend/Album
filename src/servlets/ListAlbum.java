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
import util.SessionManager;

/**
 * Servlet implementation class ListAlbum
 */
@WebServlet("/listAlbum")
public class ListAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAlbum() {
        super();
        // TODO Auto-generated constructor stub
    }
    String listAl="/WEB-INF/listAlbum.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  if (SessionManager.checkSession(request.getSession())) {
		   HttpSession session=request.getSession();
			  int id= (int) session.getAttribute("id");
			  System.out.println(id);
			
		
		try {
			request.setAttribute("album", AlbumDao.listerAlbum(id));
			getServletContext().getRequestDispatcher(listAl).forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  }
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);	
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
