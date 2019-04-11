package me.minhaz;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		Integer i=Integer.parseInt(req.getParameter("userName"));
		Integer j=Integer.parseInt(req.getParameter("password"));
		try{
			PrintWriter output=res.getWriter();
			output.println("<h1>"+(i+j)+"</H1>");
		}catch(Exception e) {
			System.out.println("Error");
			System.out.println("Error:  "+e);
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) {

		try{
			PrintWriter output=res.getWriter();
			output.println("<h1> Invalid Request GET</H1>");
		}catch(Exception e) {
			System.out.println("Error");
			System.out.println("Error:  "+e);
		}
	}
	
	
	
	
	
	/*
	 * public void service(HttpServletRequest req,HttpServletResponse res){
	 * 
	 * }
	 */
		



	

}
