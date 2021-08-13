package com.revature.ers.dao;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.EmployeeMapper;
import com.revature.ers.util.ManagerEntity;
import com.revature.ers.util.ManagerMapper;

public class EmployeeRegistrationDaoImpl implements EmployeeRegistrationDao{
	Logger logger=Logger.getLogger(EmployeeRegistrationDaoImpl.class);
	final LocalDateTime now=LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy KK:mm:ss a");
    String localTime = now.format(formatter);
//add employee starts	
	 public void addEmployee(Employee e) {
		 logger.info("entered into add employee");
		 e.setAddedOn(localTime.toString());
		 e.setUpdatedOn("");
		 
		 Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			
			EmployeeEntity empEntity=EmployeeMapper.mapModelEntity(e);
			session.beginTransaction();
			session.save(empEntity);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		 logger.info("finished adding employee"); 
	 }
//add employee ends
	 
//add manager starts
	 public void addManager(Manager m) {
		 logger.info("entered into add manager");
		 m.setAddedOn(localTime.toString());
		 m.setUpdatedOn("");
		 
		 Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			
			ManagerEntity managerEntity=ManagerMapper.mapModelEntity(m);
			session.beginTransaction();
			session.save(managerEntity);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		 logger.info("finished adding manager"); 
	 }
//add manager ends

//update employee starts
	@Override
	public void updateEmployee(Employee employee) {
		 logger.info("entered into update employee");
		employee.setUpdatedOn(localTime.toString());
		 
		 Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			
			EmployeeEntity employeeEntity=EmployeeMapper.mapModelEntity(employee);
			session.beginTransaction();
			session.merge(employeeEntity);
			session.flush();
			session.getTransaction().commit();
			session.close();
		} catch (Exception e1) {
			
			logger.warn(e1.getMessage());
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		 logger.info("finished updating employee");
	} 
//update employee ends
	 
}
