package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TableSchema;
import Model.Tables;
import Model.Users;

@WebServlet(urlPatterns="/homepage.jsp")
public class HomepageController extends HttpServlet {
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//SessionController.checkSession(request,response);
		ResultSet index=TableSchema.getAllTableName();
		request.setAttribute("index", index);
	
		try {
			if(index.next()) {
				
				if(request.getParameter("id")!=null) {
					String tableName=(String)request.getParameter("id");
					ResultSet columnName=TableSchema.getAllColumnName(tableName);
					request.setAttribute("column", columnName);
					request.setAttribute("tableName", tableName);
					ResultSet data=TableSchema.getAllData(tableName);
					request.setAttribute("data", data);
					//System.out.println( "Data Is :");
				}else {
				
					String tableName= (String)index.getString("TABLE_NAME");
					ResultSet columnName=TableSchema.getAllColumnName(tableName);
					request.setAttribute("column", columnName);
					request.setAttribute("tableName", tableName);
					ResultSet data=TableSchema.getAllData(tableName);
					request.setAttribute("data", data);
				}
				//;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		request.getRequestDispatcher("/WEB-INF/Views/homepage.jsp").forward(request,response);
	}
}
