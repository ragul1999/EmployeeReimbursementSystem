package com.revature.ers.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.service.ManagerReimbursementUpdateService;
import com.revature.ers.service.ManagerReimbursementUpdateServiceImpl;

public class ManagerReimbursementUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String managerId=request.getParameter("managerId");
		String pendingId=request.getParameter("pendingId");
		String  status=request.getParameter("status");
		
		ManagerReimbursementUpdateService impl=new ManagerReimbursementUpdateServiceImpl();
		PendingReimbursement pending=new PendingReimbursement();
		pending.setPendingId(Integer.parseInt(pendingId));
		pending.setManagerId(Integer.parseInt(managerId));
		if("approved".equals(status)) {
		
			impl.approveReimbursement(pending);
			
		}
		else {
			
			impl.rejectReimbursement(pending);
		}
		
		
		
		
		response.sendRedirect("http://localhost:8080/controller/manager_home.html?id="+managerId);
	}

}
