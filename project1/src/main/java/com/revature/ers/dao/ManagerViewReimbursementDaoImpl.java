package com.revature.ers.dao;

import java.util.ArrayList;
import java.util.List;

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
	
//view pending reimbursement starts	
	@Override
	public List<PendingReimbursementEntity> getPendingReimbursement(){
		List<PendingReimbursementEntity> pendingList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from PendingReimbursementEntity e");
				 pendingList=q.list();
				 
			
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return pendingList;
}
//view pending reimbursement ends 

//view rejected reimbursement starts
	@Override
	public List<RejectedReimbursementEntity> getRejectedReimbursement() {
		List<RejectedReimbursementEntity> rejectedList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from RejectedReimbursementEntity r");
				rejectedList=q.list();
				session.close();
			
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return rejectedList;
		
		
	}
//view rejected reimbursement ends 
	
//view resolved reimbursement starts
	@Override
	public List<ResolvedReimbursementEntity> getResolvedReimbursement() {
		List<ResolvedReimbursementEntity> resolvedList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from ResolvedReimbursementEntity e");
				resolvedList=q.list();
				session.close();
			
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return resolvedList;
		
		
	}

//view resolved reimbursement ends 
	
//View all employees starts
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from EmployeeEntity e");
				employeeList=q.list();
				session.close();
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return employeeList;
	}
		
	
	
//view all employees ends
	
}
