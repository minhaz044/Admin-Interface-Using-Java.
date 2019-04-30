package Controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout.jsp")	
public class LogoutController extends HttpServlet{

 protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	if(SessionController.checkSession(request)) {
		 HttpSession session=request.getSession();
		 session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}else {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

 }
 protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	if(SessionController.checkSession(request)) {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");

	}else {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}
 }
}
