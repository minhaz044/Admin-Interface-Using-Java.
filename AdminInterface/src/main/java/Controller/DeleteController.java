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

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		
		//System.out.println("This is from do ");
		
		try {
			request.setAttribute("tableName",request.getParameter("name"));
			request.setAttribute("id",request.getParameter("id") );
			request.getRequestDispatcher("/WEB-INF/Views/delete.jsp").forward(request,response);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
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
		
		
	}
	

}
