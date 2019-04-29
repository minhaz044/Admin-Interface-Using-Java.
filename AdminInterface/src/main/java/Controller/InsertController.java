package Controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.TableSchema;
import Services.Forms;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@WebServlet(urlPatterns="/add.jsp")
public class InsertController  extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//SessionController.checkSession(request,response);
		if(request.getParameter("name")!=null) {
			String tableName=request.getParameter("name");
			ResultSet columnName=TableSchema.getAllColumnName(tableName);
			Forms form=new Forms("POST","add.jsp");
			String type=null;
			String name=null;
			String temptype=null;
			form.varchar(null, "Hidden", "tableName", tableName,"");
			
			int counter =0;
			try {
						columnName.next();
						while(columnName.next()) {
							
							temptype=columnName.getString("DATA_TYPE");
							if(temptype.equals("int")) {
								type="number";
							}else if(temptype.equals("datetime")) {
								type="datetime-local";
							}else  {
								type="text";
							}
							name=columnName.getString("COLUMN_NAME");
							if(counter==0) {
								form.varchar(name, type, name,"","required");
								counter++;
							}else {
								form.varchar(name, type, name,"","required");								
							}
					}
				request.setAttribute("forms", form.getForm());
				request.getRequestDispatcher("/WEB-INF/Views/add.jsp").forward(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				response.sendRedirect(request.getContextPath() + "/homepage.jsp");
			} catch (IOException e) {
				log.error("From @insert @doGet @Catch:"+ e);
			}
		}	
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		//SessionController.checkSession(request,response);
		
		if(request.getParameter("tableName")!=null ) {
			ArrayList<String> data=new ArrayList();
			ArrayList<String> index=new ArrayList();
			String columnName;
			HttpSession session=request.getSession();
			ResultSet tableInfo=TableSchema.getAllColumnName(request.getParameter("tableName"));
			try {
				while(tableInfo.next()){
					System.out.println("************************Is In While *********************************");
					columnName=tableInfo.getString("COLUMN_NAME");
					index.add(columnName);
					data.add(request.getParameter(columnName));
					System.out.println(columnName + " : "+ request.getParameter(columnName));
				}
				
				if(TableSchema.insert(request.getParameter("tableName"),index,data)) {
						log.info("Insertion Successfull");
						session.setAttribute("message", "Insertion Sucessfull");
						session.setAttribute("msgType", "text-success");
						response.sendRedirect(request.getContextPath() + "/homepage.jsp?id="+request.getParameter("tableName"));
					
				}else {
					log.info("Insertion Failed");
					session.setAttribute("message", "Insertion Failed");
					session.setAttribute("msgType", "text-danger");
				}
				
				

			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			}
			else {
			log.error("Invalid Input ! \n Try Again ");
			
		}
		
	}
}
