package com.revature.ers.dao;

import java.util.List;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public interface ViewReimbursementByEmployeeIdDao {
	public List<PendingReimbursementEntity> getPendingReimbursementByEmpId(Reimbursement reimburse);
	public List<ResolvedReimbursementEntity> getResolvedReimbursementByEmpId(Reimbursement reimburse);
	public List<RejectedReimbursementEntity> getRejectedReimbursementByEmpId(Reimbursement reimburse);
	
}
