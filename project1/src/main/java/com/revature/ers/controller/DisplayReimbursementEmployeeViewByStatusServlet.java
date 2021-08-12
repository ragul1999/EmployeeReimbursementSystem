package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ViewReimbursementService;
import com.revature.ers.service.ViewReimbursementServiceImpl;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class DisplayReimbursementEmployeeViewByStatusServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String status=request.getParameter("status");
		String empId=request.getParameter("empId");
		
		if(empId==null || "".equals(empId)){
			String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
			invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
			out.println(invalidLogin);
		}
		
		else {
		Reimbursement reimburse=new Reimbursement();
		ViewReimbursementService impl=new ViewReimbursementServiceImpl();
		List<PendingReimbursementEntity> pendingList=null;
		List<RejectedReimbursementEntity> rejectedList=null;
		 List<ResolvedReimbursementEntity> resolvedList=null;
		
		
		if(empId!=null && "resolved".equals(status)) {
			reimburse.setEmployeeId(Integer.parseInt(empId));
			 resolvedList= impl.getResolvedReimbursementByEmpId(reimburse);
			
		}
		else if(empId!=null && "rejected".equals(status)) {
			reimburse.setEmployeeId(Integer.parseInt(empId));
			 rejectedList=impl.getRejectedReimbursementByEmpId(reimburse);
		}
		else if(empId!=null && "pending".equals(status)) {
			reimburse.setEmployeeId(Integer.parseInt(empId));
			pendingList=impl.getPendingReimbursementByEmpId(reimburse);
		}
			
		
		/* displaying expense reimbursement list starts*/
		
		String resultPage="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    \r\n"
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
				+ "          border-collapse: collapse;\r\n"
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
				+ "</head>\r\n"
				+ "        <h2 style=\"color:#5890FF;text-align: center;\">"+status.substring(0,1).toUpperCase()+status.substring(1)+" Expense Reimbursement History of Employee id: "+empId+"</h2>\r\n";
				
		
					resultPage+= "<div class=\"container\"><a href=\"http://localhost:8080/controller/employee_home.html?id="+empId+"\">Back to Home</a><br><br>\r\n";
				
				
				
				resultPage+= "    <table id=\"customers\">\r\n"
				+ "        <tr>\r\n"
				+ "          <th>Employee Id</th>\r\n"
				+ "          <th>Reimbursement Type</th>\r\n"
				+ "          <th>Days spent</th>\r\n"
				+ "          <th>Amount</th>\r\n"
				+ "          <th>Description</th>\r\n"
				+ "          <th>Date of applied</th>\r\n"
				+"            <th>Status Id</th> \r\n"	
				+ "          <th>Status</th>\r\n"
				+ "          <th>Taken action on</th></tr>\r\n";
				
	if(pendingList!=null) {	
		for(PendingReimbursementEntity list:pendingList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getPendingId()+"</td><td>Pending</td>"
					+"</td><td>"+list.getUpdatedOn()+"</td>";
				
		}
	}
	
	if(resolvedList!=null) {
		for(ResolvedReimbursementEntity list:resolvedList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getResolvedId()+"</td><td>Approved</td>"
					+"<td>"+list.getUpdatedOn()+"</td>";
			
			resultPage+= "</tr>";
				
		}
	}
	
	if(rejectedList!=null) {
		for(RejectedReimbursementEntity list:rejectedList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getRejectedId()+"</td><td>Rejected</td>"
					+"<td>"+list.getUpdatedOn()+"</td>";
		
			resultPage+= "</tr>";			
				
		}
	}
		resultPage+=" </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
		/* displaying expense reimbursement list ends*/
		
		
		
	}	
	
	}
	

}
