package me.minhaz;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		/*
		Integer i=Integer.parseInt(req.getParameter("userName"));
		Integer j=Integer.parseInt(req.getParameter("password"));
		*/
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String csrf=req.getParameter("csrf");

		String data1="Hello";
		String data2="Minhaz";
		
		/*
		 * Cookie cookie=new Cookie("data1",data1); res.addCookie(cookie);
		 * 
		 * cookie=new Cookie("data2",data2); res.addCookie(cookie);
		 */
	
		try{
			
			
			//System.out.println("Is in Post");
			// RequestDispatcher rd=req.getRequestDispatcher("other");
			// rd.forward(req, res);
			HttpSession session=req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			//session.
			
			res.sendRedirect("other");
			 
			
			/*
			PrintWriter output=res.getWriter();
			output.println("<h1>"+(i+j)+"</H1>");
			*/
		}catch(Exception e) {
			System.out.println("Error");
			System.out.println("Error:  "+e);
		}
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) {

		try{
			req.setAttribute("k", 50);
		
			RequestDispatcher rd=req.getRequestDispatcher("/other");
			rd.forward(req, res);
			/*
			PrintWriter output=res.getWriter();
			output.println("<h1> Invalid Request GET</H1>");
			*/
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
