package com.revature.ers.service;

import com.revature.ers.dao.ManagerReimbursementUpdateDao;
import com.revature.ers.dao.ManagerReimbursementUpdateDaoImpl;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public class ManagerReimbursementUpdateServiceImpl implements ManagerReimbursementUpdateService {
	ManagerReimbursementUpdateDao impl=new ManagerReimbursementUpdateDaoImpl();
	
	@Override
	public void rejectReimbursement(PendingReimbursement pending) {
		impl.rejectReimbursement(pending);
		
	}

	@Override
	public void approveReimbursement(PendingReimbursement pending) {
		
		impl.approveReimbursement(pending);
	}

}
