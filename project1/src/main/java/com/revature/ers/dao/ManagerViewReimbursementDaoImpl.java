package com.revature.ers.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerViewReimbursementDaoImpl implements ManagerViewReimbursementDao {
	Logger logger=Logger.getLogger(ManagerViewReimbursementDaoImpl.class);
//view pending reimbursement starts	
	@Override
	public List<PendingReimbursementEntity> getPendingReimbursement(){
		 logger.info("entered into getPendingReimbursement");
		List<PendingReimbursementEntity> pendingList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from PendingReimbursementEntity e");
				 pendingList=q.list();
				 
			
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getPendingReimbursement");
	return pendingList;
}
//view pending reimbursement ends 

//view rejected reimbursement starts
	@Override
	public List<RejectedReimbursementEntity> getRejectedReimbursement() {
		 logger.info("entered into getRejectedReimbursement");
		List<RejectedReimbursementEntity> rejectedList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from RejectedReimbursementEntity r");
				rejectedList=q.list();
				session.close();
			
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getRejectedReimbursement");
	return rejectedList;
		
		
	}
//view rejected reimbursement ends 
	
//view resolved reimbursement starts
	@Override
	public List<ResolvedReimbursementEntity> getResolvedReimbursement() {
		 logger.info("entered into getResolvedReimbursement");
		List<ResolvedReimbursementEntity> resolvedList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from ResolvedReimbursementEntity e");
				resolvedList=q.list();
				session.close();
			
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getResolvedReimbursement"); 
	return resolvedList;
		
		
	}

//view resolved reimbursement ends 
	
//View all employees starts
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		 logger.info("entered into getAllEmployees");
		List<EmployeeEntity> employeeList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from EmployeeEntity e");
				employeeList=q.list();
				session.close();
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getAllEmployees"); 
	return employeeList;
	}
		
	
	
//view all employees ends
	
}
