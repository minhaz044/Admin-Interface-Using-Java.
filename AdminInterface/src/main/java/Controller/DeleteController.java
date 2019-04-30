package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TableSchema;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(urlPatterns="/delete.jsp")
public class DeleteController extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		if(SessionController.checkSession(request)){

			try {
				request.setAttribute("tableName",request.getParameter("name"));
				request.setAttribute("id",request.getParameter("id") );
				request.getRequestDispatcher("/WEB-INF/Views/delete.jsp").forward(request,response);
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else {
			HttpSession session=request.getSession();
			session.setAttribute("message", "Please Login!");
			session.setAttribute("msgType", "text-danger");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}

	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(SessionController.checkSession(request)){
			if(TableSchema.delete(request.getParameter("name"), request.getParameter("id"))) {
				HttpSession session=request.getSession();
				session.setAttribute("message", "Deleted Sucessfull");
				session.setAttribute("msgType", "text-success");
				response.sendRedirect(request.getContextPath() + "/homepage.jsp?id="+request.getParameter("name")+"");
			}else {
				HttpSession session=request.getSession();
				session.setAttribute("message", "Operation Failed");
				session.setAttribute("msgType", "text-danger");
			}	
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("message", "Please Login!");
			session.setAttribute("msgType", "text-danger");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	
  }


}
