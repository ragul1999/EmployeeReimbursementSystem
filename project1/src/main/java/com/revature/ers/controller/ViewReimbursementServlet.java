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

public class ViewReimbursementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String status=request.getParameter("status");
		Reimbursement reimburse=new Reimbursement();
		reimburse.setEmployeeId(id);
		
		ViewReimbursementService serviceImpl=new ViewReimbursementServiceImpl();
		if(status == null || status.isEmpty()) {
			List<Reimbursement> viewList=serviceImpl.viewReimbursementHistoryByEmpId(reimburse);
			request.getSession().setAttribute("employeeList",viewList);
		}
		
		else {
			reimburse.setStatus(status);
			List<Reimbursement> viewList=serviceImpl.viewReimbursementHistoryOfEmpByStatus(reimburse);
			request.getSession().setAttribute("employeeList",viewList);
		}
		
		
		//http://localhost:8080/controller/DisplayReimbursementServlet
		//set it as session attribute you can access it anywhere inside application like below.
		//request.getSession().setAttribute("name",mails);
		//and you can access it in second servlet as
		//ArrayList<String> list=(ArrayList<List>)request.getSession().getAttribute("name");
	
		
		response.sendRedirect("http://localhost:8080/controller/DisplayReimbursementServlet");
	}

}
