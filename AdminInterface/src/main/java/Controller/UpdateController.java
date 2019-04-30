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
@WebServlet(urlPatterns="/update.jsp")
public class UpdateController extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(SessionController.checkSession(request)){
			if(request.getParameter("name")!=null && request.getParameter("id")!=null) {
				String tableName=request.getParameter("name");
				String id=request.getParameter("id");
				ResultSet tableIndex=null;
				ResultSet tableInfo=TableSchema.getAllColumnName(tableName);
				try {
					System.out.println("This is from DeGet Index 1 :"+tableInfo.getString("COLUMN_NAME") );
				} catch (SQLException e2) {
					System.out.println("No Data Found");
				}
				try {
					System.out.println("tableInfo:"+tableInfo.getString(1));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ResultSet tableData=TableSchema.get(tableName, id);
				Forms form=new Forms("POST","update.jsp");
				String type=null;
				String name=null;
				String temptype=null;
				String CurrentIndex=null;
				form.varchar(null, "Hidden", "tableName", tableName,"");
				int counter =0;
				try {
					if(tableData.next()) {
							while(tableInfo.next()) {
								temptype=tableInfo.getString("DATA_TYPE");
								CurrentIndex=tableInfo.getString("COLUMN_NAME");
								
								if(temptype.equals("int")) {
									type="number";
								}else if(temptype.equals("datetime")) {
									type="datetime-local";
								}else  {
									type="text";
								}
								name=tableInfo.getString("COLUMN_NAME");
								if(counter==0) {
									form.varchar(name, type, name, tableData.getString(CurrentIndex),"readonly");
									counter++;
								}else {
									form.varchar(name, type, name, tableData.getString(CurrentIndex),"");								
								}

								
							}
						}

					request.setAttribute("forms", form.getForm());
					request.getRequestDispatcher("/WEB-INF/Views/update.jsp").forward(request,response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else {
				try {
					response.sendRedirect(request.getContextPath() + "/homepage.jsp");
				} catch (IOException e) {
					log.error("From @update @doGet @Catch:"+ e);
					
				}
			}
			
			
			
			
			
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("message", "Please Login!");
			session.setAttribute("msgType", "text-danger");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
		
		
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		if(SessionController.checkSession(request)){
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
					
					if(TableSchema.update(request.getParameter("tableName"),index,data)) {
							log.info("Update Successfull");
							
							session.setAttribute("message", "Updated Sucessfull");
							session.setAttribute("msgType", "text-success");
							response.sendRedirect(request.getContextPath() + "/update.jsp?id="+data.get(0)+"&name="+request.getParameter("tableName"));
						
					}else {
						log.info("Update Failed");
						session.setAttribute("message", "Updated Failed");
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
		}else {
			HttpSession session=request.getSession();
			session.setAttribute("message", "Please Login!");
			session.setAttribute("msgType", "text-danger");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	
		
		
	}
}
