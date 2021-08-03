package com.revature.ers.service;

import java.util.List;
import com.revature.ers.model.Reimbursement;

public interface ManagerViewReimbursementService {
	public List<Reimbursement> managerViewReimbursement();
	public List<Reimbursement> managerViewReimbursementByStatus(Reimbursement reimburse);
}
