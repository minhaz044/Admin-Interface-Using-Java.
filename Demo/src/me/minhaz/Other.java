package me.minhaz;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Other extends HttpServlet  {

	
	public void doGet(HttpServletRequest req,HttpServletResponse res)   {
		System.out.println("Hello Hunny banny ");
		System.out.println(req.getAttribute("k"));
		//int a=Integer.parseInt(req.getParameter("k"));
				

				
		try {
			
			HttpSession session=req.getSession();
			
			PrintWriter out=res.getWriter();
			Cookie cookie[]=req.getCookies();
			
			for(Cookie c:cookie) {
				out.println(c.getComment());
			}
			
			

			out.println("<h1>UserName: "+session.getAttribute("userName")+"</h1>");
			out.println("<h1>PassWord: "+session.getAttribute("password")+"</h1>");
			
			//out.println(req.getAttribute("k")+"Hello From Othere");

		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)   {
		try {
			PrintWriter out=res.getWriter();
			out.println("Jhnfishdgfhsgdfy");
			
			//out.println(req.getAttribute("k")+"Hello From Othere");

		}catch (Exception e) {
			// TODO: handle exception
		}
	
	}
}
