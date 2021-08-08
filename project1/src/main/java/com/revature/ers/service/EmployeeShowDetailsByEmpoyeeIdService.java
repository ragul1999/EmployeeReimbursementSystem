package com.revature.ers.service;

import java.util.List;

import com.revature.ers.model.Employee;
import com.revature.ers.util.EmployeeEntity;

public interface EmployeeShowDetailsByEmpoyeeIdService {
	public 	List<EmployeeEntity> getEmployeeByEmployeeId(Employee e);
}
