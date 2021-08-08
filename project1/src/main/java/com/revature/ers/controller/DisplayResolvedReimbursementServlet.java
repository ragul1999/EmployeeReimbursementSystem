package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;


public class DisplayResolvedReimbursementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String managerId=request.getParameter("managerId");
		PrintWriter out=response.getWriter();
		
		ArrayList<ResolvedReimbursementEntity> resolvedList=(ArrayList<ResolvedReimbursementEntity>)request.getSession().getAttribute("resolvedList");
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
				+ "        <h2 style=\"color:#5890FF;text-align: center;\">Resolved Expense Reimbursement History</h2>\r\n"
				+ "        <div class=\"container\"><a href=\""+"http://localhost:8080/controller/manager_home.html?id="+managerId+"\">Back to Home</a><br><br>\r\n"
				+ "    <table id=\"customers\">\r\n"
				+ "        <tr>\r\n"
				+ "          <th>Resolved Id</th>\r\n"
				+ "          <th>Employee Id</th>\r\n"
				+ "          <th>Type</th>\r\n"
				+ "          <th>Days spent</th>\r\n"
				+ "          <th>Amount</th>\r\n"
				+ "          <th>Description</th>\r\n"
				+ "          <th>Date of applied</th>\r\n"
				+ "          <th>Manager Id</th>\r\n"
				+ "          <th>Updated on</th>\r\n";
				
		
		
		for(ResolvedReimbursementEntity list:resolvedList) {
			
			resultPage+="<tr><td>"+list.getResolvedId()+"</td><td>"
					+list.getEmployeeId()+"</td><td>"+list.getReimburseType()+"</td><td>"
					+list.getDaysSpent()+"</td><td>"+list.getReimburseAmount()
					+"</td><td>"+list.getDescription()+"</td><td>"+list.getAddedOn()+"</td><td>"
					+(list.getManagerId()==-1?"":list.getManagerId())+"</td><td>"+list.getUpdatedOn()+"</td>";
					
			
		}
		resultPage+="</tr> </table>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		out.println(resultPage);
		
		
	}

}
