package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.revature.ers.db.DBUtil;
import com.revature.ers.model.Reimbursement;

public class EmployeeReimbursementDaoImpl implements EmployeeReimbursementDao{
	final LocalDateTime localTime=LocalDateTime.now();
	
	public void addReimbursement(Reimbursement reimburse) {

		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into ers_reimbursementtable(employeeid,reimburse_type,days_spent,reimburse_amount,description,date_of_applied, status) values(?,?,?,?,?,?,?)");
	
			pst.setInt(1,reimburse.getEmployeeId());
			pst.setString(2,reimburse.getReimburseType());
			pst.setInt(3, reimburse.getDaysSpent());
			pst.setInt(4,reimburse.getReimburseAmount());
			pst.setString(5,reimburse.getDescription()); 
			pst.setString(6,localTime.toString());
			pst.setString(7,"pending");
			int rowsChanged=pst.executeUpdate();
			if(rowsChanged==1) {
				System.out.println("data inserted..");
			}
			else {
				System.out.println("Couldn't add expense reimbursement details..");
			}
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		 
	}

}
