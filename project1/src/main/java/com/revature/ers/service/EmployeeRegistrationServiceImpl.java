package com.revature.ers.service;

import com.revature.ers.dao.EmployeeRegistrationDao;
import com.revature.ers.dao.EmployeeRegistrationDaoImpl;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService{
	EmployeeRegistrationDao employeeDao=new EmployeeRegistrationDaoImpl();
	 public void addEmployee(Employee e) {
		 employeeDao.addEmployee(e);
		 
	 }
	 public void addManager(Manager m) {
		 employeeDao.addManager(m);
		 
	 }
}
