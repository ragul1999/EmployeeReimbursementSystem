package com.revature.ers.service;

import java.util.List;

import com.revature.ers.dao.EmployeeShowDetailsByEmpoyeeIdDao;
import com.revature.ers.dao.EmployeeShowDetailsByEmpoyeeIdDaoImpl;
import com.revature.ers.model.Employee;
import com.revature.ers.util.EmployeeEntity;


public class EmployeeShowDetailsByEmpoyeeIdServiceImpl implements EmployeeShowDetailsByEmpoyeeIdService{

	public 	List<EmployeeEntity> getEmployeeByEmployeeId(Employee e){	
	List<EmployeeEntity> result=null;
	try {
		EmployeeShowDetailsByEmpoyeeIdDao daoImpl=new EmployeeShowDetailsByEmpoyeeIdDaoImpl();
		result=daoImpl.getEmployeeByEmployeeId(e);
	}
	catch(Exception e1) {
		e1.printStackTrace();
	}
	return result;
}
}
