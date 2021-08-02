package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.revature.ers.db.DBUtil;
import com.revature.ers.model.Employee;

public class EmployeeRegistrationDaoImpl implements EmployeeRegistrationDao{
	final LocalDateTime localTime=LocalDateTime.now();
	 public void addEmployee(Employee e) {
		
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into ers_employeetable(id,name,department,designation,email,type,password,addedOn) values(?,?,?,?,?,?,?,?)");
			pst.setInt(1,e.getEmployeeId());
			pst.setString(2,e.getEmployeeName());
			pst.setString(3, e.getDepartment());
			pst.setString(4,e.getDesignation());
			pst.setString(5,e.getEmail()); 
			pst.setString(6,e.getType());
			pst.setString(7, e.getPassword());
			pst.setString(8,localTime.toString());
			int rowsChanged=pst.executeUpdate();
			if(rowsChanged==1) {
				System.out.println("data inserted..");
			}
			else {
				System.out.println("Couldn't add employee details..");
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		 
	 }
}
