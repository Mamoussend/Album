package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
 * Servlet implementation class Permission
 */
@WebServlet("/permission")
public class Permission extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String perm="/WEB-INF/permission.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Permission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  if (SessionManager.checkSession(request.getSession())) {
			   HttpSession session=request.getSession();
				  int id= (int) session.getAttribute("id");
				  System.out.println(id);
				
			
			try {
				request.setAttribute("user", UtilisateurDao.listUser());
			
				getServletContext().getRequestDispatcher(perm).forward(request, response);
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
		String id=(String) request.getParameter("id");
		
		String[] names = request.getParameterValues("names");
		List list = Arrays.asList(names);
		request.setAttribute("names", list);
		if(UtilisateurDao.addpermission(list,Integer.parseInt(id))) {
			response.sendRedirect(request.getContextPath()+"/user");
		}
		else {
		response.sendRedirect(request.getContextPath()+"/permission");	
		}
	}

}
