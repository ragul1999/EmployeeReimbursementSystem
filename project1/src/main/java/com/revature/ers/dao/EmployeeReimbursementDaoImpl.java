package com.revature.ers.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.PendingReimbursementMapper;
import com.revature.ers.util.ReimbursementEntity;
import com.revature.ers.util.ReimbursementMapper;

public class EmployeeReimbursementDaoImpl implements EmployeeReimbursementDao{
	Logger logger=Logger.getLogger(EmployeeReimbursementDaoImpl.class);
	final LocalDateTime now=LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy KK:mm:ss a");
    String localTime = now.format(formatter);
	
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse) {
		 logger.info("entered into add Reimbursement");
		Session session=HibernateUtil.getSessionFactory().openSession();
		pendingReimburse.setAddedOn(localTime.toString());
		
		
		//converting model class into entity class
		ReimbursementEntity request=ReimbursementMapper.mapModelEntity(reimburse);
		PendingReimbursementEntity pendingRequest=PendingReimbursementMapper.mapModelEntity(pendingReimburse);
		//1-1 mapping
		request.setPendingId(pendingRequest);
		
		try {
			session.beginTransaction();
			session.save(request);
			session.flush();
			session.getTransaction().commit();
			session.close();
			
		} catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		 logger.info("finished adding Reimbursement"); 
	}

}
