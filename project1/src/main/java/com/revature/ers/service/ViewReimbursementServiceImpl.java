package com.revature.ers.service;

import java.util.List;

import com.revature.dao.ViewReimbursementDao;
import com.revature.dao.ViewReimbursementDaoImpl;
import com.revature.ers.model.Reimbursement;

public class ViewReimbursementServiceImpl implements ViewReimbursementService {
	
	public List<Reimbursement> viewReimbursementHistoryByEmpId(Reimbursement reimburse){
		List<Reimbursement> result=null;
		try {
			ViewReimbursementDao daoImpl=new ViewReimbursementDaoImpl();
			result=daoImpl.viewReimbursementHistoryByEmpId(reimburse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
