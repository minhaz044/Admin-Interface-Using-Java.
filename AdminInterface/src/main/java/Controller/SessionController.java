package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionController {
	public static Boolean destroy(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
		  session.invalidate();
		  return true;
		   
		} else {
			return false;
		}
	}
	public static Boolean checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null || session.getAttribute("userName") == null || session.getAttribute("password") == null ) {
			request.setAttribute("message", "Please Login!");
			request.setAttribute("msgType", "text-success");
			return false;
		} 
		return true;
	}
}
