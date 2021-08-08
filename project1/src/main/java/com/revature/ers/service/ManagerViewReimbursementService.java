package com.revature.ers.service;

import java.util.List;


import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public interface ManagerViewReimbursementService {
	public List<PendingReimbursementEntity> getPendingReimbursement();
	public List<ResolvedReimbursementEntity> getResolvedReimbursement();
	public List<RejectedReimbursementEntity> getRejectedReimbursement();
	public List<EmployeeEntity> getAllEmployees();
}
