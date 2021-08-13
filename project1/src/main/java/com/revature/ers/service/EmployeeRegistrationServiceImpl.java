package com.revature.ers.service;

import org.apache.log4j.Logger;

import com.revature.ers.dao.EmployeeRegistrationDao;
import com.revature.ers.dao.EmployeeRegistrationDaoImpl;
import com.revature.ers.model.Employee;
import com.revature.ers.model.Manager;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService{
	Logger logger=Logger.getLogger(EmployeeRegistrationServiceImpl.class);
	EmployeeRegistrationDao employeeDao=new EmployeeRegistrationDaoImpl();
	 public void addEmployee(Employee e) {
		 employeeDao.addEmployee(e);
		 logger.info("inside addEmployee");
	 }
	 public void addManager(Manager m) {
		 employeeDao.addManager(m);
		 logger.info("inside addManager");
	 }
	@Override
	public void updateEmployee(Employee employee) {
		 employeeDao.updateEmployee(employee);
		 logger.info("inside updateEmployee");
	}
}
