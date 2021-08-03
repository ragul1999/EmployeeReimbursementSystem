package com.revature.ers.service;

import java.util.List;

import com.revature.ers.model.Reimbursement;

public interface ViewReimbursementService {
	public List<Reimbursement> viewReimbursementHistoryByEmpId(Reimbursement reimburse);
	public List<Reimbursement> viewReimbursementHistoryOfEmpByStatus(Reimbursement reimburse);
}
