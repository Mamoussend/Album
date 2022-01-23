package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImageDao;
import util.SessionManager;

/**
 * Servlet implementation class Main
 */
@WebServlet({"/main",""})
public class Main extends HttpServlet {
	String path_home="/WEB-INF/home.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println(request.getContextPath());
		try {
			request.setAttribute("image", ImageDao.listerImagepublic());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			getServletContext().getRequestDispatcher(path_home).forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println(request.getContextPath());
	}

}
