package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.revature.ers.db.DBUtil;
import com.revature.ers.model.Employee;

public class EmployeeRegistrationDaoImpl {
	
	 public void addEmployee(Employee e) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			PreparedStatement pst=con.prepareStatement("insert into ers values(?,?,?,?,?,?,?)");
			pst.setInt(1,e.getEmployeeId());
			pst.setString(3,e.getEmployeeName());
			pst.setString(4, e.getDepartment());
			pst.setString(5,e.getDesignation());
			pst.setString(6,e.getEmail()); 
			pst.setString(7,e.getType());
			pst.setString(2, e.getPassword());
			pst.execute();
			System.out.println("data inserted..");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	 }
}
