package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.dao.ViewReimbursementByEmployeeIdDaoImpl;
import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class DisplayAllReimbursementServlet extends HttpServlet {
	Logger logger=Logger.getLogger(DisplayAllReimbursementServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("entered into doGet");
		response.setContentType("text/html");
		String managerId=request.getParameter("managerId");
		PrintWriter out=response.getWriter();
		
		if(managerId==null) {
			String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
			invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
			out.println(invalidLogin);
		}
		
		/* displaying expense reimbursement history list starts*/
		else {	
		String resultPage="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <style>\r\n"
				+ "        .container{\r\n"
				+ "        margin-left: 1%;\r\n"
				+ "        margin-right:1%;\r\n"
				+ "        width: 98%;\r\n"
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
				+ "</head>\r\n"
				+ "        <h2 style=\"color:#5890FF;text-align: center;\">Expense Reimbursement History</h2>\r\n"
				+ "        <div class=\"container\"><a href=\"http://localhost:8080/controller/manager_home.html?id="+managerId+"\">Back to Home</a><br><br>\r\n"
				+ "    <table id=\"customers\">\r\n"
				+ "        <tr>\r\n"
				+"             <th>Status Id</th>  \r\n"
				+ "          <th>Employee Id</th>\r\n"
				+ "          <th>Type</th>\r\n"
				+ "          <th>Days spent</th>\r\n"
				+ "          <th>Amount</th>\r\n"
				+ "          <th>Description</th>\r\n"
				+ "          <th>Date of applied</th>\r\n"
				+ "          <th>Status</th>\r\n"
				+ "          <th>Manager Id</th>\r\n"
				+ "          <th>Updated on</th>\r\n"
				+ "          <th>Action</th></tr>\r\n";
		
		ManagerViewReimbursementService serviceImpl=new ManagerViewReimbursementServiceImpl();
		List<PendingReimbursementEntity> pendingList=serviceImpl.getPendingReimbursement();
		List<RejectedReimbursementEntity> rejectedList=serviceImpl.getRejectedReimbursement();
		List<ResolvedReimbursementEntity> resolvedList=serviceImpl.getResolvedReimbursement();
		
		for(PendingReimbursementEntity list:pendingList) {
			resultPage+="<tr><td>"+list.getPendingId()+"</td><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>pending</td>"
					+"<td>"+(list.getManagerId()==-1?"":list.getManagerId())+"</td><td>"+list.getUpdatedOn()+"</td>"
					+"<td><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=approved&managerId="+managerId+"&pendingId="+list.getPendingId() +"'>Approve \r\n"
					+ "</a><span> or </span><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=rejected&managerId="+managerId+"&pendingId="+list.getPendingId() +"'> \r\n"
					+ "Reject</a></td>";
				
		}
		
		for(ResolvedReimbursementEntity list:resolvedList) {
		resultPage+="<tr><td>"+list.getResolvedId()+"</td><td>"
				+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
				+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
				+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>approved</td><td>"
				+(list.getManagerId()==-1?"":list.getManagerId())+"</td><td>"+list.getUpdatedOn()+"</td><td></td>";
		
		}
		
		for(RejectedReimbursementEntity list:rejectedList) {
			
			resultPage+="<tr><td>"+list.getRejectedId()+"</td><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>rejected</td><td>"
					+(list.getManagerId()==-1?"":list.getManagerId())+"</td><td>"+list.getUpdatedOn()+"</td><td></td>";
					
			
		}
		
		
		resultPage+="</tr> </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
		/* displaying expense reimbursement list ends*/
		logger.info("finished printing result");
		}
	
	}

}
