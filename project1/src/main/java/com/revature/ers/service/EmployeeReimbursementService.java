package com.revature.ers.service;

import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public interface EmployeeReimbursementService {
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse);
}
