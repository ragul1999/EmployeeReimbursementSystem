package com.revature.ers.dao;

import java.time.LocalDateTime;
import org.hibernate.Session;
import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.PendingReimbursementMapper;
import com.revature.ers.util.ReimbursementEntity;
import com.revature.ers.util.ReimbursementMapper;

public class EmployeeReimbursementDaoImpl implements EmployeeReimbursementDao{
	final LocalDateTime localTime=LocalDateTime.now();
	
	public void addReimbursement(Reimbursement reimburse,PendingReimbursement pendingReimburse) {
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
			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		 
	}

}
