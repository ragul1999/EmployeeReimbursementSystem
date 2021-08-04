package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.revature.ers.db.DBUtil;
import com.revature.ers.model.Reimbursement;

public class ManagerReimbursementUpdateDaoImpl implements ManagerReimbursementUpdateDao {
	final LocalDateTime localTime=LocalDateTime.now();
	@Override
	public void updateReimbursement(Reimbursement reimburse) {
			
			try {
				Connection con=DBUtil.getConnection();
				PreparedStatement pst=con.prepareStatement("update ers_reimbursementtable set status=?,managerid=?,updatedOn=? where reimburse_id=? ");
				pst.setString(1,reimburse.getStatus());
				pst.setInt(2,reimburse.getManagerId());
				pst.setString(3,localTime.toString());
				pst.setInt(4,reimburse.getReimburseId());
				
				int rowsChanged=pst.executeUpdate();
				if(rowsChanged==1) {
					System.out.println("data updated for reimburseid="+reimburse.getReimburseId());
				}
				else {
					System.out.println("Couldn't update reimbursement details..");
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			 
		 }


	

}
