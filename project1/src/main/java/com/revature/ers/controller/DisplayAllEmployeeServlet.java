package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Employee;
import com.revature.ers.service.EmployeeShowDetailsByEmpoyeeIdService;
import com.revature.ers.service.EmployeeShowDetailsByEmpoyeeIdServiceImpl;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;


public class DisplayAllEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String managerId=request.getParameter("managerId");
		String empId=request.getParameter("empId");
	
		
	if(empId==null &&managerId==null) {
		String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
		invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
		out.println(invalidLogin);
	}
	
	else {
		List<EmployeeEntity> employeeList=null;
		
		if(managerId==null && empId!=null) {
			Employee emp=new Employee();
			emp.setEmployeeId(Integer.parseInt(empId));
			EmployeeShowDetailsByEmpoyeeIdService empImpl=new EmployeeShowDetailsByEmpoyeeIdServiceImpl();
			employeeList=empImpl.getEmployeeByEmployeeId(emp);
		}
		else {
			employeeList=(List<EmployeeEntity>)request.getSession().getAttribute("employeeList");
		}
		String resultPage="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <style>\r\n"
				+ "        .container{\r\n"
				+ "        margin-left: 10%;\r\n"
				+ "        margin-right:10%;\r\n"
				+ "        width: 80%;\r\n"
				+ "        display: inline-block;\r\n"
				+ "            \r\n"
				+ "        }\r\n"
				+ "       #customers {\r\n"
				+ "          font-family: arial, sans-serif;\r\n"
				+ "          border-collapse:collapse;\r\n"
				+ "        \r\n"
				+ "        \r\n"
				+ "        }\r\n"
				+ "        #customers tr:hover {background-color: #ddd;}\r\n"
				+ "        td, th {\r\n"
				+ "          border: 1px solid #dddddd;\r\n"
				+ "          text-align: left;\r\n"
				+ "          padding: 8px;\r\n"
				+ "        }\r\n"
				+ "        \r\n"
				+ "        tr:nth-child(even) {\r\n"
				+ "          background-color: #dddddd;\r\n"
				+ "        }\r\n"
				+ "  #customers th {\r\n"
				+ "      padding-top: 12px;\r\n"
				+ "      padding-bottom: 12px;\r\n"
				+ "      text-align: left;\r\n"
				+ "      background-color: #04AA6D;\r\n"
				+ "      color: white;\r\n"
				+ "    }\r\n"
				+ "        </style>\r\n"
				+ "       \r\n"
				+ "</head>\r\n";
		if(managerId==null && empId!=null) {
				resultPage+= "  <h2 style=\"color:#5890FF;text-align: center;\">Employee Details</h2>\r\n"
				 +"<div class=\"container\"><a href=\""+"http://localhost:8080/controller/employee_home.html?id="+empId+"\">Back to Home</a>\r\n"
				+"<a href='#' style='float:right'>Update Details?</a> <br><br>";
		}
		else {
			resultPage+= "  <h2 style=\"color:#5890FF;text-align: center;\">All Employee Details</h2>\r\n"
			+ "<div class=\"container\"><a href=\""+"http://localhost:8080/controller/manager_home.html?id="+managerId+"\">Back to Home</a><br><br>\r\n";
			}
				
		resultPage+= "    <table id=\"customers\">\r\n"
				+ "        <tr>\r\n"
				+ "          <th>Employee Id</th>\r\n"
				+ "          <th>Employee name</th>\r\n"
				+ "          <th>Department</th>\r\n"
				+ "          <th>Designation</th>\r\n"
				+ "          <th>Email</th>\r\n"
				+ "          <th>Details added on</th>\r\n"
				+ "          <th>recently updated on</th>\r\n";
			
		
		
		for(EmployeeEntity list:employeeList) {
			
			resultPage+="<tr><td>"+list.getEmployeeId()+"</td><td>"
					+list.getEmployeeName()+"</td><td>"+list.getDepartment()+"</td><td>"
					+list.getDesignation()+"</td><td>"+list.getEmail()
					+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getUpdatedOn()+"</td>";
					
					
			
		}
		resultPage+="</tr> </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
	}	
	}

}
