package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.ManagerViewReimbursementDao;
import com.revature.ers.dao.ManagerViewReimbursementDaoImpl;
import com.revature.ers.model.Reimbursement;

public class ManagerViewReimbursementServiceImpl implements ManagerViewReimbursementService{
	public List<Reimbursement> managerViewReimbursement(){
		List<Reimbursement> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.managerViewReimbursement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Reimbursement> managerViewReimbursementByStatus(Reimbursement reimburse){
		List<Reimbursement> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.managerViewReimbursementByStatus(reimburse);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
