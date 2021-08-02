package com.revature.ers.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Employee;
import com.revature.ers.service.EmployeeRegistrationService;
import com.revature.ers.service.EmployeeRegistrationServiceImpl;



public class EmployeeRegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String department=request.getParameter("department");
		String designation=request.getParameter("designation");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("type");
	//	String newid=IDGenerator.generateID();
		//model is mapped
		Employee employee=new Employee();
		employee.setEmployeeId(Integer.parseInt(id));
		employee.setEmployeeName(name);
		employee.setDepartment(department);
		employee.setDesignation(designation);
		employee.setType(type);
		employee.setEmail(email);
		employee.setPassword(pwd);
		
		//service need to be invoked 
		EmployeeRegistrationService employeeService =new EmployeeRegistrationServiceImpl();
		try {
		employeeService.addEmployee(employee); 
		out.println("<h2 style='text-align=center'> Registration / Sign up success</h2><br>");
		out.println("<h3 style='text-align=center'>This page will be redirected to login page</h3>");
		//method to redirect after 5 seconds
		response.sendRedirect("http://localhost:8080/controller/login.html");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
