package com.revature.ers.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.PendingReimbursement;
import com.revature.ers.util.PendingReimbursementEntity;
import com.revature.ers.util.ReimbursementEntity;
import com.revature.ers.util.RejectedReimbursementEntity;
import com.revature.ers.util.ResolvedReimbursementEntity;

public class ManagerReimbursementUpdateDaoImpl implements ManagerReimbursementUpdateDao {
	final LocalDateTime now=LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy KK:mm:ss a");
    String localTime = now.format(formatter);
	
	@Override
	public void rejectReimbursement(PendingReimbursement pending) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			RejectedReimbursementEntity rr=new RejectedReimbursementEntity();
			Query ee=session.createQuery("from PendingReimbursementEntity p where pending_id=:pendingId",PendingReimbursementEntity.class).setParameter("pendingId",pending.getPendingId());
			List<PendingReimbursementEntity> plist=ee.list();
			plist.stream().forEach(p->{
				rr.setEmployeeId(p.getEmployeeId());
				rr.setAddedOn(p.getAddedOn());
				rr.setDaysSpent(p.getDaysSpent());
				rr.setDescription(p.getDescription());
				rr.setManagerId(pending.getManagerId());
				rr.setReimburseAmount(p.getReimburseAmount());
				rr.setReimburseType(p.getReimburseType());
				rr.setUpdatedOn(localTime.toString());
				
			});
			
			Query ee1=session.createQuery("from ReimbursementEntity c where pending_id=:pendingId").setParameter("pendingId",pending.getPendingId());
			
			List<ReimbursementEntity> rl=ee1.list();
			rl.stream().forEach(p->{
				session.delete(p);
				p.setPendingId(null);
				session.flush();
				p.setRejectedId(rr);
				session.save(p);
			});
			
			
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		
	}
	@Override
	public void approveReimbursement(PendingReimbursement pending) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			ResolvedReimbursementEntity rr=new ResolvedReimbursementEntity();
			Query ee=session.createQuery("from PendingReimbursementEntity p where pending_id=:pendingId",PendingReimbursementEntity.class).setParameter("pendingId",pending.getPendingId());
			List<PendingReimbursementEntity> plist=ee.list();
			plist.stream().forEach(p->{
				rr.setEmployeeId(p.getEmployeeId());
				rr.setAddedOn(p.getAddedOn());
				rr.setDaysSpent(p.getDaysSpent());
				rr.setDescription(p.getDescription());
				rr.setManagerId(pending.getManagerId());
				rr.setReimburseAmount(p.getReimburseAmount());
				rr.setReimburseType(p.getReimburseType());
				rr.setUpdatedOn(localTime.toString());
				
			});
			
			Query ee1=session.createQuery("from ReimbursementEntity c where pending_id=:pendingId").setParameter("pendingId",pending.getPendingId());
			
			List<ReimbursementEntity> rl=ee1.list();
			rl.stream().forEach(p->{
				session.delete(p);
				p.setPendingId(null);
				session.flush();
				p.setResolvedId(rr);
				session.save(p);
			});
			
				session.getTransaction().commit();
				session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}	
	}
}
