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
import dao.ImageDao;
import util.SessionManager;

/**
 * Servlet implementation class User
 */
@WebServlet("/user")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (SessionManager.checkSession(request.getSession())) {
			 HttpSession session=request.getSession();
			  String type= (String) session.getAttribute("type");
				String user="/WEB-INF/user.jsp?id="+type;
			  request.setAttribute("type", type);
			  System.out.println("le type est : "+type);
				try {
					request.setAttribute("image", ImageDao.listerImage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			getServletContext().getRequestDispatcher(user).forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/main");
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
