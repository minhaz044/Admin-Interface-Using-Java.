package Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Tables;
import Model.Users;

@WebServlet(urlPatterns="/homepage.jsp")
public class HomepageController extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		ResultSet index=Tables.getAll();
		System.out.println(index);
		ResultSet data=Users.getAll();
		request.setAttribute("index", index);
		request.setAttribute("data", data);
	
		request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp").forward(request,response);
	}
}
