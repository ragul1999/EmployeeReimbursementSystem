package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Employee;

public class EmployeeLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("type");
		
		Employee employee=new Employee();
		employee.setEmployeeId(Integer.parseInt(id));
		employee.setPassword(pwd);
		employee.setType(type);
		
	}

}
