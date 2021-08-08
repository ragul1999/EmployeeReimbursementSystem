package com.revature.ers.dao;

import java.util.List;


import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public interface ManagerViewReimbursementDao {
	public List<PendingReimbursementEntity> getPendingReimbursement();
	public List<RejectedReimbursementEntity> getRejectedReimbursement();
	public List<ResolvedReimbursementEntity> getResolvedReimbursement();
	public List<EmployeeEntity> getAllEmployees();
}
