package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.ManagerViewReimbursementDao;
import com.revature.ers.dao.ManagerViewReimbursementDaoImpl;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerViewReimbursementServiceImpl implements ManagerViewReimbursementService{
	@Override
	public List<PendingReimbursementEntity> getPendingReimbursement(){
		List<PendingReimbursementEntity> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.getPendingReimbursement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ResolvedReimbursementEntity> getResolvedReimbursement() {
		List<ResolvedReimbursementEntity> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.getResolvedReimbursement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<RejectedReimbursementEntity> getRejectedReimbursement() {
		List<RejectedReimbursementEntity> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.getRejectedReimbursement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> list=null;
		try {
			ManagerViewReimbursementDao impl=new ManagerViewReimbursementDaoImpl();
			list=impl.getAllEmployees();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
