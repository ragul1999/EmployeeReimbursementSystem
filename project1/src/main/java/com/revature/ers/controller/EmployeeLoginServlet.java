package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.bo.ValidateEmployee;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;

public class EmployeeLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("type");
		
		//invalid login-if login details are incorrect
		String invalidLogin="<h3 style='color:red; text-align:center;'>Login details are incorrect</h3>";
		invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Back to Login</a>";
		
		//notFoundWarning - if entered id is not present in our database
		String notFoundWarn="<h3 style='color:red; text-align:center;'>Entered Login Id doesn't exist, Register first and try login</h3>";
		notFoundWarn+="<a href='http://localhost:8080/controller/signup.html' style='display:inline-block;text-align:center'>Register here</a>";
		
		ValidateEmployee val=new ValidateEmployee();//to check employee is a valid entry
		try {
			if("E".equals(type)) {
				Employee employee=new Employee();
				employee.setEmployeeId(Integer.parseInt(id));
				employee.setPassword(pwd);
				
				if(!val.isAlreadyExistEmployee(employee)) {
					
					out.println(notFoundWarn);
				}
				
				else if(val.checkEmployee(employee)) {
					
					String link="http://localhost:8080/controller/employee_home.html?id="+id;
					response.sendRedirect(link);
				}
				else {
					
					out.println(invalidLogin);
				}
			}
			else {
				Manager manager=new Manager();
				manager.setManagerId(Integer.parseInt(id));
				manager.setPassword(pwd);
				
				if(!val.isAlreadyExistManager(manager)){
					
					out.println(notFoundWarn);
				}
				
				else if(val.checkManager(manager)){
				
					String link="http://localhost:8080/controller/manager_home.html?id="+id;
					response.sendRedirect(link);
				}
				else {
					
					out.println(invalidLogin);
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
