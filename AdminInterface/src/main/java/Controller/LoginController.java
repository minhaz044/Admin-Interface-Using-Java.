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
		String userName=request.getParameter("uname");
		String password=request.getParameter("pwd");
		HttpSession session=request.getSession();
		Users user=Users.get(userName,password);
	try {
		if(user!=null) {
			log.info("Login Sucessfull");
			session.setAttribute("message", "Login Sucessfull");
			session.setAttribute("msgType", "text-success");
			session.setAttribute("id",user.getId());
			session.setAttribute("userName",user.getUserName());
			session.setAttribute("password",user.getPassword());
			response.sendRedirect(request.getContextPath() + "/homepage.jsp");
		}else {
			request.setAttribute("message", "Failed To login ");
			request.setAttribute("msgType", "text-danger");
			request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request,response);
		}
	} catch (Exception e) {
		log.error("Error From LoginController: "+e);
	}
}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FROM DOGET ");
		request.getRequestDispatcher("/WEB-INF/Views/login.jsp").forward(request,response);
	}
	

}
