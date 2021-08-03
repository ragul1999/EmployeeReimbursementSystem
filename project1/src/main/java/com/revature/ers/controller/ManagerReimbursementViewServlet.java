package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;
import com.revature.ers.service.ViewReimbursementService;
import com.revature.ers.service.ViewReimbursementServiceImpl;

public class ManagerReimbursementViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String status=request.getParameter("status");
		
		Reimbursement reimburse=new Reimbursement();
		reimburse.setStatus(status);
		
		ManagerViewReimbursementService serviceImpl=new ManagerViewReimbursementServiceImpl();
		if(status == null || status.isEmpty()) {
			List<Reimbursement> viewList=serviceImpl.managerViewReimbursement();
			request.getSession().setAttribute("reimburseList",viewList);
		}
		
		else {
			reimburse.setStatus(status);
			List<Reimbursement> viewList=serviceImpl.managerViewReimbursementByStatus(reimburse);
			request.getSession().setAttribute("reimburseList",viewList);
		}
		
		
		//http://localhost:8080/controller/DisplayReimbursementServlet
		//set it as session attribute you can access it anywhere inside application like below.
		//request.getSession().setAttribute("name",mails);
		//and you can access it in second servlet as
		//ArrayList<String> list=(ArrayList<List>)request.getSession().getAttribute("name");
	
		
		response.sendRedirect("http://localhost:8080/controller/DisplayReimbursementManagerServlet");
	}

		
		
		//http://localhost:8080/controller/ManagerReimbursementViewServlet
	
	}



