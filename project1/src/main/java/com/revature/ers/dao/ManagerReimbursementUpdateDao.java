package com.revature.ers.dao;

import com.revature.ers.model.PendingReimbursement;


public interface ManagerReimbursementUpdateDao {
	
	public void rejectReimbursement(PendingReimbursement pending);
	public void approveReimbursement(PendingReimbursement pending);
}
