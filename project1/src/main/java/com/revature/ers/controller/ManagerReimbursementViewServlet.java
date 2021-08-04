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
import com.revature.ers.service.ManagerViewReimbursementService;
import com.revature.ers.service.ManagerViewReimbursementServiceImpl;
import com.revature.ers.service.ViewReimbursementService;
import com.revature.ers.service.ViewReimbursementServiceImpl;

public class ManagerReimbursementViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String status=request.getParameter("status");
		String managerId=request.getParameter("managerId");
		String empId=request.getParameter("empId");
		
		Reimbursement reimburse=new Reimbursement();
		List<Reimbursement> viewList=new ArrayList<Reimbursement>();
		ManagerViewReimbursementService serviceImpl=new ManagerViewReimbursementServiceImpl();
		
		if(status == null || status.isEmpty()) {
			viewList=serviceImpl.managerViewReimbursement();
			request.getSession().setAttribute("reimburseList",viewList);
			response.sendRedirect("http://localhost:8080/controller/DisplayReimbursementManagerServlet?managerId="+managerId);
		}
		else if(empId !=null && !empId.isEmpty() ) {
			reimburse.setEmployeeId(Integer.parseInt(empId));
			ViewReimbursementService impl=new ViewReimbursementServiceImpl();
			 viewList=impl.viewReimbursementHistoryByEmpId(reimburse);
			request.getSession().setAttribute("employeeList",viewList);
			response.sendRedirect("http://localhost:8080/controller/DisplayReimbursementServlet");
		}
		
		else {
			reimburse.setStatus(status);
			viewList=serviceImpl.managerViewReimbursementByStatus(reimburse);
			request.getSession().setAttribute("reimburseList",viewList);
			response.sendRedirect("http://localhost:8080/controller/DisplayReimbursementManagerServlet?managerId="+managerId);
			
		}
		
		
		//http://localhost:8080/controller/DisplayReimbursementServlet
		//set it as session attribute you can access it anywhere inside application like below.
		//request.getSession().setAttribute("name",mails);
		//and you can access it in second servlet as
		//ArrayList<String> list=(ArrayList<List>)request.getSession().getAttribute("name");
	
		
	}

		
		
		//http://localhost:8080/controller/ManagerReimbursementViewServlet
	
	}



