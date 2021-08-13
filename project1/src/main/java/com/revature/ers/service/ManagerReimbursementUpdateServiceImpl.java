package com.revature.ers.service;

import org.apache.log4j.Logger;

import com.revature.ers.dao.ManagerReimbursementUpdateDao;
import com.revature.ers.dao.ManagerReimbursementUpdateDaoImpl;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;

public class ManagerReimbursementUpdateServiceImpl implements ManagerReimbursementUpdateService {
	Logger logger=Logger.getLogger(ManagerReimbursementUpdateServiceImpl.class);
	ManagerReimbursementUpdateDao impl=new ManagerReimbursementUpdateDaoImpl();
	
	@Override
	public void rejectReimbursement(PendingReimbursement pending) {
		impl.rejectReimbursement(pending);
		logger.info("inside rejectReimbursement");
	}

	@Override
	public void approveReimbursement(PendingReimbursement pending) {
		
		impl.approveReimbursement(pending);
		logger.info("inside approveReimbursement");
	}

}
