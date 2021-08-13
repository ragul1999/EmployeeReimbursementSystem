package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerReimbursementViewServlet extends HttpServlet {
	Logger logger=Logger.getLogger("DisplayAllEmployeeServlet.class");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 logger.info("entered into doGet");
		response.setContentType("text/html");
		String status=request.getParameter("status");
		String managerId=request.getParameter("managerId");
		PrintWriter out=response.getWriter();
		
		//to avoid manager id null exceptions
		if(managerId==null ) {
			String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
			invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
			out.println(invalidLogin);
		}
		
		else {
		
		ManagerViewReimbursementService serviceImpl=new ManagerViewReimbursementServiceImpl();
		
		 if("pending".equals(status) ) {
		
		List<PendingReimbursementEntity>pendingList=serviceImpl.getPendingReimbursement();
			request.getSession().setAttribute("pendingList",pendingList);
			 logger.info("inside pending reimbursement display");
			response.sendRedirect("http://localhost:8080/controller/DisplayPendingReimbursementServlet?managerId="+managerId);
			
			
			
		}
		
		else if("rejected".equals(status) ) {
			List<RejectedReimbursementEntity> rejectedList=serviceImpl.getRejectedReimbursement();
			request.getSession().setAttribute("rejectedList",rejectedList);
			 logger.info("inside rejected reimbursement display");
			response.sendRedirect("http://localhost:8080/controller/DisplayRejectedReimbursementServlet?managerId="+managerId);
		}	
	
		else if("resolved".equals(status)){
			List<ResolvedReimbursementEntity> resolvedList=serviceImpl.getResolvedReimbursement();
			request.getSession().setAttribute("resolvedList",resolvedList);
			 logger.info("inside resolved reimbursement display");
			response.sendRedirect("http://localhost:8080/controller/DisplayResolvedReimbursementServlet?managerId="+managerId);
		}	
		else if("employees".equals(status)) {
			List<EmployeeEntity> employeeList=serviceImpl.getAllEmployees();
			request.getSession().setAttribute("employeeList",employeeList);
			 logger.info("inside get all employee display");
			response.sendRedirect("http://localhost:8080/controller/DisplayAllEmployeeServlet?managerId="+managerId);
		
		}
			
		}
		
		
	}
	
	
}



