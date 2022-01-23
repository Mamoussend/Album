package util;

import javax.servlet.http.HttpSession;

public class SessionManager {

	public SessionManager() {
		// TODO Auto-generated constructor stub
	}
	public  static boolean checkSession(HttpSession session) {
		if(session.getAttribute("connected")!=null && (boolean)session.getAttribute("connected")==true) 
			return true;
		    return false;
	}

}
