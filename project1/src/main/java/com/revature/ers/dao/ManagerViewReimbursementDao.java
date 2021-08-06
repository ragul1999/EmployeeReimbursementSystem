package com.revature.ers.dao;

import java.util.List;

import com.revature.ers.model.Reimbursement;

public interface ManagerViewReimbursementDao {
	public List<Reimbursement> managerViewReimbursement();
	public List<Reimbursement> managerViewReimbursementByStatus(Reimbursement reimburse);
}
