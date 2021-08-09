package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.ViewReimbursementByEmployeeIdDao;
import com.revature.ers.dao.ViewReimbursementByEmployeeIdDaoImpl;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ViewReimbursementServiceImpl implements ViewReimbursementService {
	@Override
	public List<PendingReimbursementEntity> getPendingReimbursementByEmpId(Reimbursement reimburse) {
		List<PendingReimbursementEntity> result=null;
		try {
			ViewReimbursementByEmployeeIdDao daoImpl=new ViewReimbursementByEmployeeIdDaoImpl();
			result=daoImpl.getPendingReimbursementByEmpId(reimburse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}






	@Override
	public List<ResolvedReimbursementEntity> getResolvedReimbursementByEmpId(Reimbursement reimburse) {
		List<ResolvedReimbursementEntity> result=null;
		try {
			ViewReimbursementByEmployeeIdDao daoImpl=new ViewReimbursementByEmployeeIdDaoImpl();
			result=daoImpl.getResolvedReimbursementByEmpId(reimburse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	@Override
	public List<RejectedReimbursementEntity> getRejectedReimbursementByEmpId(Reimbursement reimburse) {
		List<RejectedReimbursementEntity> result=null;
		try {
			ViewReimbursementByEmployeeIdDao daoImpl=new ViewReimbursementByEmployeeIdDaoImpl();
			result=daoImpl.getRejectedReimbursementByEmpId(reimburse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	





	
}
