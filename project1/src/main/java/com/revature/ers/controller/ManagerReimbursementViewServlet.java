package com.revature.ers.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerReimbursementViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String status=request.getParameter("status");
		String managerId=request.getParameter("managerId");
		//String empId=request.getParameter("empId");
		
		
		
		ManagerViewReimbursementService serviceImpl=new ManagerViewReimbursementServiceImpl();
		
		
		
	if("pending".equals(status) ) {
		
		List<PendingReimbursementEntity>pendingList=serviceImpl.getPendingReimbursement();
			request.getSession().setAttribute("pendingList",pendingList);
			
			response.sendRedirect("http://localhost:8080/controller/DisplayPendingReimbursementServlet?managerId="+managerId);
			
			
			
		}
		
		else if("rejected".equals(status) ) {
			List<RejectedReimbursementEntity> rejectedList=serviceImpl.getRejectedReimbursement();
			request.getSession().setAttribute("rejectedList",rejectedList);
			
			response.sendRedirect("http://localhost:8080/controller/DisplayRejectedReimbursementServlet?managerId="+managerId);
		}	
	
		else if("resolved".equals(status)){
			List<ResolvedReimbursementEntity> resolvedList=serviceImpl.getResolvedReimbursement();
			request.getSession().setAttribute("resolvedList",resolvedList);
			
			response.sendRedirect("http://localhost:8080/controller/DisplayResolvedReimbursementServlet?managerId="+managerId);
		}	
		else if("employees".equals(status)) {
			List<EmployeeEntity> employeeList=serviceImpl.getAllEmployees();
			request.getSession().setAttribute("employeeList",employeeList);
			
			response.sendRedirect("http://localhost:8080/controller/DisplayAllEmployeeServlet?managerId="+managerId);
		
		}
			
	
		
		
	}
	
	
}



