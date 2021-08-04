package com.revature.ers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ManagerReimbursementUpdateService;
import com.revature.ers.service.ManagerReimbursementUpdateServiceImpl;
import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;

public class ManagerReimbursementUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String managerId=request.getParameter("managerId");
		String reimburseId=request.getParameter("reimburseId");
		String  status=request.getParameter("status");
		
		Reimbursement reimburse=new Reimbursement();
		reimburse.setManagerId(Integer.parseInt(managerId));
		reimburse.setReimburseId(Integer.parseInt(reimburseId));
		reimburse.setStatus(status);
		
		ManagerReimbursementUpdateService serviceImpl=new ManagerReimbursementUpdateServiceImpl();
		serviceImpl.updateReimbursement(reimburse);
		response.sendRedirect("http://localhost:8080/controller/manager_home.html?id="+managerId);
	}

}
