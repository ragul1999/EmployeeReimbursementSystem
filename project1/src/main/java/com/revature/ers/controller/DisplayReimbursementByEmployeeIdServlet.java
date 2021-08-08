package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class DisplayReimbursementByEmployeeIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String managerId=request.getParameter("managerId");
		String empId=request.getParameter("empId");
		
		
		Reimbursement reimburse=new Reimbursement();
		if(empId!=null || !("".equals(empId))) {
			ViewReimbursementService impl=new ViewReimbursementServiceImpl();
			reimburse.setEmployeeId(Integer.parseInt(empId));
			List<PendingReimbursementEntity> pendingList=impl.getPendingReimbursementByEmpId(reimburse);
			 List<ResolvedReimbursementEntity> resolvedList= impl.getResolvedReimbursementByEmpId(reimburse);
			 List<RejectedReimbursementEntity> rejectedList=impl.getRejectedReimbursementByEmpId(reimburse);
			
		
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
				+ "        <h2 style=\"color:#5890FF;text-align: center;\">Expense Reimbursement History of Employee id: "+empId+"</h2>\r\n";
				if(managerId!=null) {
					resultPage+= "<div class=\"container\"><a href=\"http://localhost:8080/controller/manager_home.html?id="+managerId+"\">Back to Home</a><br><br>\r\n";
				}
				else{
					resultPage+= "<div class=\"container\"><a href=\"http://localhost:8080/controller/employee_home.html?id="+empId+"\">Back to Home</a><br><br>\r\n";
				}
				
				
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
				+ "          <th>Taken action on</th>\r\n";
				if(managerId!=null) {
				resultPage+= "          <th>Action</th></tr>\r\n";
				}
		
		for(PendingReimbursementEntity list:pendingList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getPendingId()+"</td><td>Pending</td>"
					+"</td><td>"+list.getUpdatedOn()+"</td>";
			if(managerId!=null) {
					resultPage+="<td><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=approved&managerId="+managerId+"&pendingId="+list.getPendingId() +"'>Approve \r\n"
					+ "</a><span> or </span><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=rejected&managerId="+managerId+"&pendingId="+list.getPendingId() +"'> \r\n"
					+ "Reject</a></td>";
			}
				
		}
		for(ResolvedReimbursementEntity list:resolvedList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getResolvedId()+"</td><td>Approved</td>"
					+"<td>"+list.getUpdatedOn()+"</td>";
			if(managerId!=null) {
					resultPage+= "<td></td>";
			}
			resultPage+= "</tr>";
				
		}
		for(RejectedReimbursementEntity list:rejectedList) {
			resultPage+="<tr><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"+list.getRejectedId()+"</td><td>Rejected</td>"
					+"<td>"+list.getUpdatedOn()+"</td>";
			if(managerId!=null) {
				resultPage+= "<td></td>";
		}
			resultPage+= "</tr>";			
				
		}
		resultPage+=" </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
		/* displaying expense reimbursement list ends*/
		}
		
		else
			out.println("<h2 style='text-align:center;color:'red''>Entered an invalid Employee Id</h2>");
		
	}

}
