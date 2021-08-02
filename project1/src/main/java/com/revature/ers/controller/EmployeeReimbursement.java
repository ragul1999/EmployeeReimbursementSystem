package com.revature.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.EmployeeReimbursementService;
import com.revature.ers.service.EmployeeReimbursementServiceImpl;
import java.io.PrintWriter;



public class EmployeeReimbursement extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
			out.println("success");
				String id=request.getParameter("id");
				String reimburseType=request.getParameter("reimburse-type");
				String daysSpent=request.getParameter("days-spent");
				String amount=request.getParameter("reimburse-amount");
				String description=request.getParameter("description");
				
				
				Reimbursement reimburse=new Reimbursement();
				reimburse.setEmployeeId(Integer.parseInt(id));
				reimburse.setReimburseType(reimburseType);
				reimburse.setDaysSpent(Integer.parseInt(daysSpent));
				reimburse.setReimburseAmount(Integer.parseInt(amount));
				reimburse.setDescription(description);
				
				EmployeeReimbursementService impl=new EmployeeReimbursementServiceImpl();
				impl.addReimbursement(reimburse);
				
				String link="http://localhost:8080/controller/add_reimbursement.html?id="+id;
				response.sendRedirect(link);  
				
				
					
		

	}

}
