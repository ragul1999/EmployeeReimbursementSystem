package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Reimbursement;

public class DisplayReimbursementManagerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String managerId=request.getParameter("managerId");
		PrintWriter out=response.getWriter();
		/* displaying expense reimbursement list starts*/
		ArrayList<Reimbursement> viewList=(ArrayList<Reimbursement>)request.getSession().getAttribute("reimburseList");
		String resultPage="<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <style>\r\n"
				+ "        .container{\r\n"
				+ "        margin-left: 5%;\r\n"
				+ "        margin-right:5%;\r\n"
				+ "        width: 90%;\r\n"
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
				+ "        <div class=\"container\">\r\n"
				+ "    <table id=\"customers\">\r\n"
				+ "        <tr>\r\n"
				+ "          <th>Reimbursement ID</th>\r\n"
				+ "          <th>Employee ID</th>\r\n"
				+ "          <th>Type</th>\r\n"
				+ "          <th>Days spent</th>\r\n"
				+ "          <th>Amount</th>\r\n"
				+ "          <th>Description</th>\r\n"
				+ "          <th>Date of applied</th>\r\n"
				+ "          <th>Status</th>\r\n"
				+ "          <th>Manager Id</th>\r\n"
				+ "          <th>Updated on</th>\r\n"
				+ "          <th>Action</th></tr>\r\n";
		
		
		for(Reimbursement list:viewList) {
			
			resultPage+="<tr><td>"+list.getReimburseId()+"</td><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getDateOfApplied()+"</td><td>"
					+list.getStatus()+"</td><td>"+list.getManagerId()+"</td><td>"+list.getUpdatedOn()+"</td>";
			
			if("pending".equals(list.getStatus())){
				resultPage+="<td><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=approved&managerId="+managerId+"&reimburseId="+list.getReimburseId() +"'>Approve \r\n"
						+ "</a><span> or </span><a href='http://localhost:8080/controller/ManagerReimbursementUpdateServlet?status=rejected&managerId="+managerId+"&reimburseId="+list.getReimburseId() +"'> \r\n"
						+ "Reject</a></td>";
			}
			
		}
		resultPage+="</tr> </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
		/* displaying expense reimbursement list ends*/
	
	}

}
