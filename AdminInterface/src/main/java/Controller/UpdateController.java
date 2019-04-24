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
import Services.Forms;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebServlet(urlPatterns="/update.jsp")
public class UpdateController extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("name")!=null && request.getParameter("id")!=null) {
			System.out.println("Is is Do Get <so Function ius called");
			
			String tableName=request.getParameter("name");
			String id=request.getParameter("id");
			System.out.println(tableName +id);
			ResultSet tableIndex=null;
			ResultSet tableInfo=TableSchema.getAllColumnName(tableName);
			try {
				System.out.println("This is from DeGet Index 1 :"+tableInfo.getString("COLUMN_NAME") );
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("Npo Data Found");
			}
			try {
				System.out.println("tableInfo:"+tableInfo.getString(1));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ResultSet tableData=TableSchema.get(tableName, id);
			Forms form=new Forms();
			String type=null;
			String name=null;
			String temptype=null;
			String CurrentIndex=null;
			System.out.println("OutSide of while loop");

			try {
				if(tableData.next()) {
						while(tableInfo.next()) {
							System.out.println("InSide Of while loop");
							temptype=tableInfo.getString("DATA_TYPE");
							CurrentIndex=tableInfo.getString("COLUMN_NAME");
							
							if(temptype.equals("int")) {
								System.out.println("Is In INteger ");
								type="number";
							}else if(temptype.equals("datetime")) {
								System.out.println("Is In INteger ");
								type="datetime-local";
							}else  {
								System.out.println("Is In else");
								type="text";
							}
							name=tableInfo.getString("COLUMN_NAME");
							System.out.println(tableData.getString(CurrentIndex));
							System.out.println("*******************************************************************");
							form.varchar(name, type, name, tableData.getString(CurrentIndex));
							
						}
					}

				request.setAttribute("forms", form.getForm());
				request.getRequestDispatcher("/WEB-INF/Views/update.jsp").forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			try {
				response.sendRedirect(request.getContextPath() + "/homepage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("From @update @doGet @Catch:"+ e);
				;
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse respons) {
		
	}
}
