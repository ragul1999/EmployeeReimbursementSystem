package com.revature.ers.dao;

import java.util.List;

import com.revature.ers.model.Employee;
import com.revature.ers.util.EmployeeEntity;

public interface EmployeeShowDetailsByEmpoyeeIdDao {
	public 	List<EmployeeEntity> getEmployeeByEmployeeId(Employee e);
}
