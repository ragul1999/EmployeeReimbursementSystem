package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.ers.db.DBUtil;
import com.revature.ers.exceptions.ReimbursementNotFoundException;
import com.revature.ers.model.Reimbursement;

public class ManagerViewReimbursementDaoImpl implements ManagerViewReimbursementDao {

//view ers history of all employees starts

	@Override
	public List<Reimbursement> managerViewReimbursement() {
			List<Reimbursement> viewList=null;
				try {
					Connection con=DBUtil.getConnection();
					PreparedStatement pst=con.prepareStatement("select * from ers_reimbursementtable");
					ResultSet rst=pst.executeQuery();
					if(rst.next()) {
						viewList=new ArrayList<Reimbursement>();
						rst=pst.executeQuery();
						while(rst.next()) {
							Reimbursement reimburse=new Reimbursement();
							reimburse.setReimburseId(rst.getInt(1));
						 	reimburse.setEmployeeId(rst.getInt(2));
							reimburse.setReimburseType(rst.getString(3));
							reimburse.setDaysSpent(rst.getInt(4));
							reimburse.setReimburseAmount(rst.getInt(5));
							reimburse.setDescription(rst.getString(6));
							reimburse.setDateOfApplied(rst.getString(7));
							reimburse.setStatus(rst.getString(8));
							reimburse.setManagerId(rst.getInt(9));
							reimburse.setUpdatedOn(rst.getString(10));
							viewList.add(reimburse);
							
						}
					
				}
					else {
						throw new ReimbursementNotFoundException("Reimbursement history is empty..");
					}
				}
				catch (Exception e1) {
					
					e1.printStackTrace();
				}
				 
			 
			
			return viewList;
		}
	
//view ers history of all employees ends
	
//view ers history of all employees by status starts	
	@Override
	public List<Reimbursement> managerViewReimbursementByStatus(Reimbursement reimburse){
		List<Reimbursement> viewList=null;
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from ers_reimbursementtable where status=? ");
			pst.setString(1,reimburse.getStatus());
			ResultSet rst=pst.executeQuery();
			if(rst.next()) {
				viewList=new ArrayList<Reimbursement>();
				rst=pst.executeQuery();
				while(rst.next()) {
					reimburse=new Reimbursement();
					reimburse.setReimburseId(rst.getInt(1));
				 	reimburse.setEmployeeId(rst.getInt(2));
					reimburse.setReimburseType(rst.getString(3));
					reimburse.setDaysSpent(rst.getInt(4));
					reimburse.setReimburseAmount(rst.getInt(5));
					reimburse.setDescription(rst.getString(6));
					reimburse.setDateOfApplied(rst.getString(7));
					reimburse.setStatus(rst.getString(8));
					reimburse.setManagerId(rst.getInt(9));
					reimburse.setUpdatedOn(rst.getString(10));
					viewList.add(reimburse);
					
				}
			
		}
			else {
				throw new ReimbursementNotFoundException("Reimbursement history for the given status is empty..");
			}
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		 
	 
	
	return viewList;
}
//view ers history of all employees by status ends 
	
}
