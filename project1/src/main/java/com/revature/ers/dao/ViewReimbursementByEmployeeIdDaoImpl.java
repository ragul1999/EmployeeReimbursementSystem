package com.revature.ers.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ViewReimbursementByEmployeeIdDaoImpl implements ViewReimbursementByEmployeeIdDao {
	Logger logger=Logger.getLogger(ViewReimbursementByEmployeeIdDaoImpl.class);
	@Override
	public List<PendingReimbursementEntity> getPendingReimbursementByEmpId(Reimbursement reimburse) {
		 logger.info("entered into getPendingReimbursementByEmpId");
		List<PendingReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from PendingReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				session.close();
		}
		catch (Exception e1) {
			logger.warn(e1.getMessage());
			
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getPendingReimbursementByEmpId"); 
	return resultList;

	}
	
	public List<RejectedReimbursementEntity> getRejectedReimbursementByEmpId(Reimbursement reimburse) {
		 logger.info("entered into getRejectedReimbursementByEmpId");
		List<RejectedReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from RejectedReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				session.close();
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getRejectedReimbursementByEmpId");
	return resultList;

	}
	
	
	public List<ResolvedReimbursementEntity> getResolvedReimbursementByEmpId(Reimbursement reimburse) {
		 logger.info("entered into getResolvedReimbursementByEmpId");
		List<ResolvedReimbursementEntity> resultList=null;
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				Query q=session.createQuery("from ResolvedReimbursementEntity e where employee_id=:empId").setParameter("empId",reimburse.getEmployeeId());
				resultList=q.list();
				session.close();
		}
		catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished getResolvedReimbursementByEmpId");
	return resultList;
	}
	
	
	

	
}