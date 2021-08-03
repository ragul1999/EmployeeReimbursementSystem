package com.revature.dao;

import java.util.List;

import com.revature.ers.model.Reimbursement;

public interface ViewReimbursementDao {
	public List<Reimbursement> viewReimbursementHistoryByEmpId(Reimbursement reimburse);
	public List<Reimbursement> viewReimbursementHistoryOfEmpByStatus(Reimbursement reimburse);
}
