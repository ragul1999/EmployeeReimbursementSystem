package com.revature.ers.dao;

import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public interface EmployeeReimbursementDao {
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse);
}
