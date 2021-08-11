package com.revature.ers.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.revature.ers.bo.ValidateEmployee;
import com.revature.ers.exceptions.DuplicateIdException;
import com.revature.ers.exceptions.EmployeeNotFoundException;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;
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
		String email=request.getParameter("email").toLowerCase();
		String pwd=request.getParameter("psw");
		String type=request.getParameter("type");
		String status=request.getParameter("status");//only for employee update details
		String addedOn=request.getParameter("addedOn");//only for employee update details

	try {
		if("E".equals(type)) {
			Employee employee=new Employee();
			employee.setEmployeeId(Integer.parseInt(id));
			
			ValidateEmployee val=new ValidateEmployee();//to check employee is a valid entry
			
				if(val.isAlreadyExistEmployee(employee)) {
					try {
						String errorPage="<h3 style='text-align:center;color:red'>Entered Employee Id already exist, use login</h3>";
						errorPage+="<a href='http://localhost:8080/controller/login.html'><span style='text-align:center;display:inline-block'>Login here</span></a>";
						out.println(errorPage);
						throw new DuplicateIdException(errorPage);
					}catch(Exception e) {
						out.println(e.getMessage());
					}
				}
				else {	
				employee.setEmployeeName(name);
				employee.setDepartment(department);
				employee.setDesignation(designation);
				employee.setEmail(email);
				employee.setPassword(pwd);
				EmployeeRegistrationService employeeService =new EmployeeRegistrationServiceImpl();
				employeeService.addEmployee(employee);
				response.sendRedirect("http://localhost:8080/controller/login.html");
				}
			}
			
		
		else if("M".equals(type)) {
			Manager manager=new Manager();
			manager.setManagerId(Integer.parseInt(id));
			
			ValidateEmployee val=new ValidateEmployee();//to check manager is a valid entry
			 if(val.isAlreadyExistManager(manager)) {
				 try {
					 String errorPage="<h3 style='text-align:center;color:red'>Entered Manager Id already exist, use login</h3>";
						errorPage+="<a href='http://localhost:8080/controller/login.html'><span style='text-align:center;display:inline-block'>Login here</span></a>";
					 throw new DuplicateIdException(errorPage);
				 }catch(DuplicateIdException e) {
					 out.println(e.getMessage());
				 }
			 }
			
			 else {
			manager.setManagerName(name);
			manager.setDepartment(department);
			manager.setDesignation(designation);
			manager.setEmail(email);
			manager.setPassword(pwd);
			EmployeeRegistrationService employeeService =new EmployeeRegistrationServiceImpl();
			employeeService.addManager(manager);
			response.sendRedirect("http://localhost:8080/controller/login.html");
			 }
			
		}
		else if("update".equals(status)) {
			Employee employee=new Employee();
			employee.setEmployeeId(Integer.parseInt(id));
			ValidateEmployee val=new ValidateEmployee();//to check manager is a valid entry
			if(!val.isAlreadyExistEmployee(employee)) {
				try {
					String errorPage="<h3 style='text-align:center;color:red'>Entered Employee Id doesn't exist, please create an account using sign up</h3>";
					errorPage+="<a href='http://localhost:8080/controller/signup.html'><span style='text-align:center;display:inline-block'>Create account here</span></a>";
					out.println(errorPage);
					throw new EmployeeNotFoundException(errorPage);
				}catch(EmployeeNotFoundException e) {
					out.println(e.getMessage());
				}
			}
			
				else {
				employee.setEmployeeName(name);
				employee.setDepartment(department);
				employee.setDesignation(designation);
				employee.setEmail(email);
				employee.setAddedOn(addedOn);
				employee.setPassword(pwd);
				EmployeeRegistrationService employeeService =new EmployeeRegistrationServiceImpl();
				employeeService.updateEmployee(employee);
				response.sendRedirect("http://localhost:8080/controller/employee_home.html?id="+id);
				}
		}
		
	}catch(Exception e) {
		out.println("");
	}
		
		
		
	}

}
