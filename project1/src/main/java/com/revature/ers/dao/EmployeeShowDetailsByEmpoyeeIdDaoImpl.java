package com.revature.ers.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Employee;
import com.revature.ers.util.EmployeeEntity;

public class EmployeeShowDetailsByEmpoyeeIdDaoImpl implements EmployeeShowDetailsByEmpoyeeIdDao {
	Logger logger=Logger.getLogger(EmployeeShowDetailsByEmpoyeeIdDaoImpl.class);
public 	List<EmployeeEntity> getEmployeeByEmployeeId(Employee e){
	 logger.info("entered into getEmployeeByEmployeeId");
		List<EmployeeEntity> employeeList=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
				
				Query q=session.createQuery("from EmployeeEntity e where employee_id=:empId").setParameter("empId", e.getEmployeeId());
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
		 logger.info("finished getEmployeeByEmployeeId"); 
	return employeeList;
	}

}
