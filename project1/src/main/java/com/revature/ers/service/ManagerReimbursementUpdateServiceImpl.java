package com.revature.ers.service;

import com.revature.dao.ManagerReimbursementUpdateDao;
import com.revature.dao.ManagerReimbursementUpdateDaoImpl;
import com.revature.ers.model.Reimbursement;

public class ManagerReimbursementUpdateServiceImpl implements ManagerReimbursementUpdateService {

	@Override
	public void updateReimbursement(Reimbursement reimburse) {
		ManagerReimbursementUpdateDao daoImpl=new ManagerReimbursementUpdateDaoImpl();
		daoImpl.updateReimbursement(reimburse);

	}

}
