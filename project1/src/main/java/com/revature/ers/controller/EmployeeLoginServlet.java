package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.bo.ValidateEmployee;
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
		ValidateEmployee val=new ValidateEmployee();//to check employee is a valid entry
		try {
		if(val.checkEmployee(employee) && "E".equals(type)) {//select only employee
			String link="http://localhost:8080/controller/add_reimbursement.html?id="+id;
			response.sendRedirect(link);
		}
		else if(val.checkEmployee(employee) && "M".equals(type)) {//select only manager
			String link="http://localhost:8080/controller/manager_home.html?id="+id;
			response.sendRedirect(link);
		}
		else {
			out.println("<h3 style='color:red; text-align=center;'>Login details are incorrect</h3>");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
