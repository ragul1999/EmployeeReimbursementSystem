package com.revature.ers.bo;

import org.hibernate.Session;

import com.revature.ers.db.HibernateUtil;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;
import com.revature.ers.util.EmployeeEntity;
import com.revature.ers.util.ManagerEntity;

public class ValidateEmployee {
	public boolean checkEmployee(Employee e) throws Exception {
		boolean result=false;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			EmployeeEntity query=session.get(EmployeeEntity.class,e.getEmployeeId());
			if(query!=null && query.getEmployeeId()==e.getEmployeeId() && (query.getPassword()).equals(e.getPassword()))
				result=true;
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	
		return result;
	}
	
	public boolean checkManager(Manager m) throws Exception {
		boolean result=false;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try {
			ManagerEntity query=session.get(ManagerEntity.class,m.getManagerId());
			if(query!=null && query.getManagerId()==m.getManagerId() && (query.getPassword()).equals(m.getPassword()))
				result=true;
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	
		return result;
	}
}
