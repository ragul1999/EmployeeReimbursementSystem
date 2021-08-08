package com.revature.ers.service;

import com.revature.ers.model.PendingReimbursement;


public interface ManagerReimbursementUpdateService {
	public void rejectReimbursement(PendingReimbursement reimburse);
	public void approveReimbursement(PendingReimbursement approved);
}
