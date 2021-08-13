package com.revature.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.ers.model.Employee;
import com.revature.ers.service.EmployeeShowDetailsByEmpoyeeIdService;
import com.revature.ers.service.EmployeeShowDetailsByEmpoyeeIdServiceImpl;
import com.revature.ers.util.EmployeeEntity;

public class EmployeeDetailsUpdateServlet extends HttpServlet {
	Logger logger=Logger.getLogger(EmployeeDetailsUpdateServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 logger.info("entered into doGet");	
		response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String empId=request.getParameter("empId");
			
			if(empId==null) {
				String invalidLogin="<h3 style='color:red; text-align:center;'>Your session is invalid, login first and try again</h3>";
				invalidLogin+="<a href='http://localhost:8080/controller/login.html' style='display:inline-block;text-align:center'>Login here</a>";
				out.println(invalidLogin);
			}
			
			else {	
			
			List<EmployeeEntity> employeeList=null;
			
			if(empId!=null) {
				Employee emp=new Employee();
				emp.setEmployeeId(Integer.parseInt(empId));
				EmployeeShowDetailsByEmpoyeeIdService empImpl=new EmployeeShowDetailsByEmpoyeeIdServiceImpl();
				employeeList=empImpl.getEmployeeByEmployeeId(emp);
			}
			String empName="",dept="",desig="",email="",pwd="",addedOn="";
			
			for(EmployeeEntity e:employeeList) {
				empName=e.getEmployeeName();
				dept=e.getDepartment();
				desig=e.getDesignation();
				email=e.getEmail();
				pwd=e.getPassword();
				addedOn=e.getAddedOn();
				
			}
			
			
			String resultPage="<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "    <head>\r\n"
					+ "        <meta charset=\"UTF-8\">\r\n"
					+ "        <title>View/Update Employee Details</title>\r\n"
					+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "       <style>\r\n"
					+ "         \r\n"
					+ "        *{box-sizing: border-box} \r\n"
					+ "\r\n"
					+ "/* Full-width input fields */\r\n"
					+ "  input[type=text],input[type=email],input[type=number] {\r\n"
					+ "  width: 100%;\r\n"
					+ "  padding: 15px;\r\n"
					+ "  margin: 5px 0 22px 0;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  border: none;\r\n"
					+ "  background: #f1f1f1;\r\n"
					+ "  border-radius: 0;\r\n"
					+ "}\r\n"
					+ "form {\r\n"
					+ "    margin-left: 25%;\r\n"
					+ "    margin-right:25%;\r\n"
					+ "    width: 50%;\r\n"
					+ "    border: 3px solid #f1f1f1;\r\n"
					+ "    display: inline-block;\r\n"
					+ "}\r\n"
					+ "body {\r\n"
					+ "    padding-top: 5%;\r\n"
					+ "    \r\n"
					+ "}\r\n"
					+ "select{\r\n"
					+ "  width: 100%;\r\n"
					+ "  padding: 15px;\r\n"
					+ "  margin: 5px 0 22px 0;\r\n"
					+ "  display: inline-block;\r\n"
					+ "  border: none;\r\n"
					+ "  background: #f1f1f1;\r\n"
					+ "}\r\n"
					+ "select:focus{\r\n"
					+ "  background-color: #ddd;\r\n"
					+ "  outline: none;\r\n"
					+ "}\r\n"
					+ "input[type=text]:focus,input[type=email]:focus,input[type=number]{\r\n"
					+ "  background-color: #ddd;\r\n"
					+ "  outline: none;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "hr {\r\n"
					+ "  border: 1px solid #f1f1f1;\r\n"
					+ "  margin-bottom: 25px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/* Set a style for all buttons */\r\n"
					+ "button {\r\n"
					+ " position:relative;\r\n"
					+ "  color: white;\r\n"
					+ "  padding: 14px 20px;\r\n"
					+ "  margin: 8px 0;\r\n"
					+ "  border: none;\r\n"
					+ "  cursor: pointer;\r\n"
					+ "  opacity: 0.9;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "button:hover {\r\n"
					+ "  opacity:1;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/* Add padding to container elements */\r\n"
					+ ".container {\r\n"
					+ "  padding: 16px;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "/* Clear floats */\r\n"
					+ ".clearfix::after {\r\n"
					+ "  content: \"\";\r\n"
					+ "  clear: both;\r\n"
					+ "  display: table;\r\n"
					+ "}\r\n"
					+ "\r\n"
					+ "    .update-btn {\r\n"
					+ "        background: #0e72ed;\r\n"
					+ "        border-radius: 8px;\r\n"
					+ "        -webkit-box-sizing: border-box;\r\n"
					+ "        box-sizing: border-box;\r\n"
					+ "        color: #fff;\r\n"
					+ "        cursor: pointer;\r\n"
					+ "        display: inline-block;\r\n"
					+ "        font-size: 16px;\r\n"
					+ "        line-height: 32px;\r\n"
					+ "        margin-top: 12px;\r\n"
					+ "        padding: 8px 40px;\r\n"
					+ "        text-align: center;\r\n"
					+ "        margin: auto;\r\n"
					+ "        display: flex;\r\n"
					+ "       \r\n"
					+ "    }\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    @media (max-width: 500px){\r\n"
					+ "    .update-btn{\r\n"
					+ "    border-radius: 16px;\r\n"
					+ "    font-size: 17px;\r\n"
					+ "    line-height: 48px;\r\n"
					+ "    padding: 0;\r\n"
					+ "    width: 100%;\r\n"
					+ "    }\r\n"
					+ "} \r\n"
					+ "</style>\r\n"
					+ "        <body>\r\n"
					+ "            <form action=\"http://localhost:8080/controller/EmployeeRegistrationServlet\" style=\"border:1px solid #ccc\" autocomplete=\"off\" method=\"post\">\r\n"
					+ "                <div class=\"container\">\r\n"
					+ "                 <a href=\"http://localhost:8080/controller/employee_home.html?id="+empId+"\">Back to Home</a>\r\n"
					+ "                    <div style=\"text-align: center;\"> \r\n"
					+ "                  <h1>Employee Details</h1>\r\n"
					+ "                    </div>\r\n"
					+ "                  <hr>\r\n"
					+ "                  <input  type=\"hidden\" placeholder=\"Employee Id\" name=\"id\" value=\""+empId+"\" min=1000 max=9999 title=\"id is a four digit number, cannot contain characters\">\r\n"
					+ "                  <label for=\"name\"><b>Name</b></label>\r\n"
					+ "                  <input type=\"text\" placeholder=\"Name\" name=\"name\" value=\""+empName+"\" minlength='2' required>\r\n"
					+ "                  <label for=\"department\"><b>Department</b></label>\r\n"
					+ "                  <select name=\"department\" id=\"department\" type=\"text\" required>\r\n"
					+ "                    <option type=\"text\" value=\""+dept+"\" selected>"+dept+"</option>\r\n"
					+ "                    <option type=\"text\" value=\"Accounts and Finance\">Accounts and Finance</option>\r\n"
					+ "                    <option type=\"text\" value=\"Admin department\">Admin department</option>\r\n"
					+ "                    <option type=\"text\" value=\"HR\">HR</option>\r\n"
					+ "                    <option type=\"text\" value=\"IT services\">IT services</option>\r\n"
					+ "                    <option type=\"text\" value=\"Infrastructures\">Infrastructures</option>\r\n"
					+ "                    <option type=\"text\" value=\"Learning and development\">Learning and development</option>\r\n"
					+ "                    <option type=\"text\" value=\"Product development\">Product development</option>\r\n"
					+ "                    <option type=\"text\" value=\"Quality Assurance\">Quality Assurance</option>\r\n"
					+ "                    <option type=\"text\" value=\"Research and development\">Research and development</option>\r\n"
					+ "                    <option type=\"text\" value=\"Sales and marketing\">Sales and marketing</option>\r\n"
					+ "                    <option type=\"text\" value=\"Security and transport\">Security and transport</option>\r\n"
					+ "                    <option type=\"text\" value=\"Others\">Others</option>\r\n"
					+ "                  </select><br>\r\n"
					+ "                  \r\n"
					+ "                  <label for=\"designation\"><b>Designation</b></label>\r\n"
					+ "                  <select name=\"designation\" id=\"designation\" required>\r\n"
					+ "                    <option type=\"text\"value=\""+desig+"\" selected >"+desig+"</option>\r\n"
					+ "                    <option type=\"text\" value=\"Architect\">Architect</option>\r\n"
					+ "                    <option type=\"text\" value=\"Business Analyst\">Business Analyst</option>\r\n"
					+ "                    <option type=\"text\"  value=\"CEO\">CEO</option>\r\n"
					+ "                    <option type=\"text\"  value=\"Delivery Head\">Delivery Head</option>\r\n"
					+ "                    <option type=\"text\" value=\"Deliver Manager\">Deliver Manager</option>\r\n"
					+ "                    <option type=\"text\" value=\"director\">Director</option>\r\n"
					+ "                    <option type=\"text\" value=\"programmer-analyst\">Programmer Analyst</option>\r\n"
					+ "                    <option type=\"text\"value=\"Project Lead\">Project Lead</option>\r\n"
					+ "                    <option type=\"text\"value=\"Project Manager\">Project Manager</option>\r\n"
					+ "                    <option type=\"text\"value=\"Program Manager\">Program Manager</option>\r\n"
					+ "                    <option type=\"text\"value=\"President\">President</option>\r\n"
					+ "                    <option type=\"text\"value=\"Software Engineer\">Software Engineer</option>\r\n"
					+ "                    <option type=\"text\"value=\"System Analyst\">System Analyst</option>\r\n"
					+ "                    <option type=\"text\"value=\"Senior Software Engineer\">Senior Software Engineer</option>\r\n"
					+ "                    <option type=\"text\"value=\"Trainee Engineer\">Trainee Engineer</option>\r\n"
					+ "                    <option type=\"text\"value=\"Technical Specialist\">Technical Specialist</option>\r\n"
					+ "                    <option type=\"text\"value=\"Vice President\">Vice President</option>\r\n"
					+ "                    <option type=\"text\"value=\"Others\">Others</option>\r\n"
					+ "                  </select><br>\r\n"
					+ "                  <label for=\"email\"><b>Email</b></label>\r\n"
					+ "                  <input type=\"email\" placeholder=\"Email\" name=\"email\" value=\""+email+"\"  pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$\" title=\"email id cannot contain upper case, must contain @ and . in it. For example, sample@gmail.com\" required>\r\n"
					+ "              <input type=\"hidden\" name=\"status\" value=\"update\">       \r\n"
					+"     <input type=\"hidden\" name=\"pwd\" value=\""+pwd+"\">                      \r\n "
					+ "     <input type=\"hidden\" name=\"addedOn\" value=\""+addedOn+"\">            \r\n"
					+ "                  <div class=\"clearfix\">\r\n"
					+ "                   \r\n"
					+ "                  <button type=\"submit\" class=\"update-btn\"  >Update</button>\r\n"
					+ "                 \r\n"
					+ "                  </div>\r\n"
					+ "                </div>\r\n"
					+ "              </form>\r\n"
					+ "        \r\n"
					+ "        </body>\r\n"
					+ "    </head>\r\n"
					+ "</html>";
			
			
			
			out.println(resultPage);
			 logger.info("employee details updated by employee");	
	}
	}
}
