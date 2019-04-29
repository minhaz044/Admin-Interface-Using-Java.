package Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet{
	
 protected void doPost(HttpServletRequest request,HttpServletResponse response) {
	// SessionController.checkSession(request,response);
	 HttpSession session=request.getSession();
	 session.invalidate();
 }
 protected void doGet(HttpServletRequest request,HttpServletResponse response) {
	// SessionController.checkSession(request,response);
	 HttpSession session=request.getSession();
	 session.invalidate();
 }
}
