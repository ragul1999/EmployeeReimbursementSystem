package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.ViewReimbursementDao;
import com.revature.ers.dao.ViewReimbursementDaoImpl;
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
	
	
	public List<Reimbursement> viewReimbursementHistoryOfEmpByStatus(Reimbursement reimburse){
		List<Reimbursement> result=null;
		try {
			ViewReimbursementDao daoImpl=new ViewReimbursementDaoImpl();
			result=daoImpl.viewReimbursementHistoryOfEmpByStatus(reimburse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
