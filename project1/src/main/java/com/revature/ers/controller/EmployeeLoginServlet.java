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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("success");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String type=request.getParameter("type");
		
		
		ValidateEmployee val=new ValidateEmployee();//to check employee is a valid entry
		try {
			if("E".equals(type)) {
				Employee employee=new Employee();
				employee.setEmployeeId(Integer.parseInt(id));
				employee.setPassword(pwd);
				if(val.checkEmployee(employee)) {
					String link="http://localhost:8080/controller/employee_home.html?id="+id;
					response.sendRedirect(link);
				}
				else {
					out.println("<h3 style='color:red; text-align=center;'>Login details are incorrect</h3>");
				}
			}
			else {
				Manager manager=new Manager();
				manager.setManagerId(Integer.parseInt(id));
				manager.setPassword(pwd);
				if(val.checkManager(manager)){
					String link="http://localhost:8080/controller/manager_home.html?id="+id;
					response.sendRedirect(link);
				}
				else {
					out.println("<h3 style='color:red; text-align=center;'>Login details are incorrect</h3>");
				}
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
