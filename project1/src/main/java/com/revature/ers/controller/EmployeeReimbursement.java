package com.revature.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.exceptions.DuplicateIdException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.model.Employee;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.EmployeeReimbursementService;
import com.revature.ers.service.EmployeeReimbursementServiceImpl;
import com.revature.ers.util.PendingReimbursementEntity;

import java.io.PrintWriter;
import java.util.ArrayList;



public class EmployeeReimbursement extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				String employeeId=request.getParameter("id");
				String reimburseType=request.getParameter("reimburse-type");
				String daysSpent=request.getParameter("days-spent");
				String amount=request.getParameter("reimburse-amount");
				String description=request.getParameter("description");
				
				
				if(employeeId==null ) {
					String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
					invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
					out.println(invalidLogin);
				}
				
				else {	
				
				String	sessionId=request.getParameter("sessionId");
				
				if(!sessionId.equals(employeeId)) {
					try {
					String errorPage="<h3 style='text-align:center;color:red'>Entered employee id doesn't match with session id, please enter employee id correctly</h3>";
					errorPage+="<a href='http://localhost:8080/controller/add_reimbursement.html?id="+sessionId+"'><span style='text-align:center;display:inline-block'>Back to Add Reimbursement</span></a>";
					throw new InvalidRequestException(errorPage);
					}
					catch(InvalidRequestException e) {
						out.println(e.getMessage());
					}
				}
				
				
				
				
				else {
					Reimbursement reimburse=new Reimbursement();
					PendingReimbursement pendingReimburse=new PendingReimbursement();
					reimburse.setEmployeeId(Integer.parseInt(employeeId));
					pendingReimburse.setEmployeeId(Integer.parseInt(employeeId));
					pendingReimburse.setReimburseType(reimburseType);
					pendingReimburse.setDaysSpent(Integer.parseInt(daysSpent));
					pendingReimburse.setReimburseAmount(Integer.parseInt(amount));
					pendingReimburse.setDescription(description);
					
					EmployeeReimbursementService impl=new EmployeeReimbursementServiceImpl();
					impl.addReimbursement(reimburse,pendingReimburse);
					
					String link="http://localhost:8080/controller/reimbursement_success.html?id="+employeeId;
					response.sendRedirect(link);  
					
					}
						
				}

	}

}
