package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Users;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebServlet(urlPatterns="/login.jsp")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp");
		System.out.println( "password:"+request.getParameter("pwd"));
		Users user=Users.get(request.getParameter("uname"),request.getParameter("pwd"));
		System.out.println(user);
	try {
		if(user!=null) {
			System.out.println(request.getContextPath() );
			
			response.sendRedirect(request.getContextPath() + "/homepage.jsp");
			//request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp").sendRedirect(request,response);
			System.out.println("Sfter redirect");
		}else {
			request.setAttribute("errorMsg", "Failed To login ");
			request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request,response);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		log.error("Error From LoginController: "+e);
	}
		

	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request,response);
	}
	

}
