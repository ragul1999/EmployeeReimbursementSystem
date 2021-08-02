package com.revature.ers.service;

import com.revature.dao.EmployeeRegistrationDao;
import com.revature.dao.EmployeeRegistrationDaoImpl;
import com.revature.ers.model.Employee;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService{
	EmployeeRegistrationDao employeeDao=new EmployeeRegistrationDaoImpl();
	 public void addEmployee(Employee e) {
		 employeeDao.addEmployee(e);
		 
	 }
}
