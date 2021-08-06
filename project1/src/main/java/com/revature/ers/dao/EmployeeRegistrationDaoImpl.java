package com.revature.ers.dao;


import java.time.LocalDateTime;

import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.EmployeeMapper;
import com.revature.ers.util.ManagerEntity;
import com.revature.ers.util.ManagerMapper;

public class EmployeeRegistrationDaoImpl implements EmployeeRegistrationDao{
	final LocalDateTime localTime=LocalDateTime.now();
	
	 public void addEmployee(Employee e) {
		 e.setAddedOn(localTime.toString());
		 e.setUpdatedOn("");
		 
		 Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			
			EmployeeEntity empEntity=EmployeeMapper.mapModelEntity(e);
			session.beginTransaction();
			session.save(empEntity);
			session.getTransaction().commit();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		 
	 }
	 
	 public void addManager(Manager m) {
		 m.setAddedOn(localTime.toString());
		 m.setUpdatedOn("");
		 
		 Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			
			ManagerEntity managerEntity=ManagerMapper.mapModelEntity(m);
			session.beginTransaction();
			session.save(managerEntity);
			session.getTransaction().commit();
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		 
	 } 
	 
}
