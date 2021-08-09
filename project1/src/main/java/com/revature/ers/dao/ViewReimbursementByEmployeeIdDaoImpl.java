package com.revature.ers.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ViewReimbursementByEmployeeIdDaoImpl implements ViewReimbursementByEmployeeIdDao {

	@Override
	public List<PendingReimbursementEntity> getPendingReimbursementByEmpId(Reimbursement reimburse) {
		List<PendingReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from PendingReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return resultList;

	}
	
	public List<RejectedReimbursementEntity> getRejectedReimbursementByEmpId(Reimbursement reimburse) {
		List<RejectedReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from RejectedReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return resultList;

	}
	
	
	public List<ResolvedReimbursementEntity> getResolvedReimbursementByEmpId(Reimbursement reimburse) {
		List<ResolvedReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from ResolvedReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	return resultList;
	}
	
	
	

	
}