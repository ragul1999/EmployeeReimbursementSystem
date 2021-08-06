package com.revature.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.EmployeeReimbursementService;
import com.revature.ers.service.EmployeeReimbursementServiceImpl;
import java.io.PrintWriter;



public class EmployeeReimbursement extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				String employeeId=request.getParameter("id");
				String reimburseType=request.getParameter("reimburse-type");
				String daysSpent=request.getParameter("days-spent");
				String amount=request.getParameter("reimburse-amount");
				String description=request.getParameter("description");
				
				
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
				
				String link="http://localhost:8080/controller/add_reimbursement.html?id="+employeeId;
				response.sendRedirect(link);  
				
				
					
		

	}

}
