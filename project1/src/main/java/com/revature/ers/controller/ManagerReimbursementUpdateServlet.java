package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.service.ManagerReimbursementUpdateService;
import com.revature.ers.service.ManagerReimbursementUpdateServiceImpl;

public class ManagerReimbursementUpdateServlet extends HttpServlet {
	Logger logger=Logger.getLogger("ManagerReimbursementUpdateServlet.class");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 logger.info("entered into doGet");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String managerId=request.getParameter("managerId");
		String pendingId=request.getParameter("pendingId");
		String  status=request.getParameter("status");
		
		if(managerId==null) {
			String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
			invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
			out.println(invalidLogin);
		}
		
		else {
		ManagerReimbursementUpdateService impl=new ManagerReimbursementUpdateServiceImpl();
		PendingReimbursement pending=new PendingReimbursement();
		pending.setPendingId(Integer.parseInt(pendingId));
		pending.setManagerId(Integer.parseInt(managerId));
		if("approved".equals(status)) {
		
			impl.approveReimbursement(pending);
			 logger.info("entered into approveReimbursement");
		}
		else {
			
			impl.rejectReimbursement(pending);
			 logger.info("entered into rejectReimbursement");
		}
		
		
		
		 logger.info("redirect to manager home");
		response.sendRedirect("http://localhost:8080/controller/manager_home.html?id="+managerId);
	}
	}
}
