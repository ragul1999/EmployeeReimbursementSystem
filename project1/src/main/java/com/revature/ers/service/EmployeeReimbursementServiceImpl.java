package com.revature.ers.service;

import com.revature.dao.EmployeeReimbursementDao;
import com.revature.dao.EmployeeReimbursementDaoImpl;
import com.revature.ers.model.Reimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService{
	public void addReimbursement(Reimbursement reimburse) {
		EmployeeReimbursementDao impl= new EmployeeReimbursementDaoImpl();
		impl.addReimbursement(reimburse);
	}
}
