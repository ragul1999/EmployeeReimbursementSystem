package com.revature.ers.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.ers.dao.EmployeeReimbursementDao;
import com.revature.ers.dao.EmployeeReimbursementDaoImpl;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService{
	Logger logger=Logger.getLogger(EmployeeReimbursementServiceImpl.class);
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse) {
		EmployeeReimbursementDao impl= new EmployeeReimbursementDaoImpl();
		impl.addReimbursement(reimburse,pendingReimburse);
		logger.info("inside addReimbursement");
	}
	

}
