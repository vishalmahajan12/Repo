package com.web.application.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingupController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 PrintWriter out = resp.getWriter();
	        out.println( "Signup SimpleServlet Executed" );
	        out.flush();
	        out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		req.getSession().setAttribute("uname", req.getParameter("fname"));
		
		req.setAttribute("email", req.getParameter("email"));
		req.setAttribute("pass", req.getParameter("pass"));
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(req, resp);
	}
	
	

}
