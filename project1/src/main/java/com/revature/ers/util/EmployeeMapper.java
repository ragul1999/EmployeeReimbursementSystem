package com.revature.ers.util;

import com.revature.ers.model.Employee;


public class EmployeeMapper {
	public static EmployeeEntity mapModelEntity(Employee model) {
		EmployeeEntity mapper=new EmployeeEntity();
		mapper.setEmployeeId(model.getEmployeeId());
		mapper.setEmployeeName(model.getEmployeeName());
		mapper.setDepartment(model.getDepartment());
		mapper.setDesignation(model.getDesignation());
		mapper.setEmail(model.getEmail());
		mapper.setPassword(model.getPassword());
		mapper.setAddedOn(model.getAddedOn());
		mapper.setUpdatedOn(model.getUpdatedOn());
		
		return mapper;
}
}
