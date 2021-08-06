package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.EmployeeReimbursementDao;
import com.revature.ers.dao.EmployeeReimbursementDaoImpl;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService{
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse) {
		EmployeeReimbursementDao impl= new EmployeeReimbursementDaoImpl();
		impl.addReimbursement(reimburse,pendingReimburse);
	}
	

}
