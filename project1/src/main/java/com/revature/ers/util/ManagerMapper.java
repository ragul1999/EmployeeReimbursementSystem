package com.revature.ers.util;

import com.revature.ers.model.Manager;


public class ManagerMapper {
	public static ManagerEntity mapModelEntity(Manager model) {
		ManagerEntity mapper=new ManagerEntity();
		mapper.setManagerId(model.getManagerId());
		mapper.setManagerName(model.getManagerName());
		mapper.setDepartment(model.getDepartment());
		mapper.setDesignation(model.getDesignation());
		mapper.setEmail(model.getEmail());
		mapper.setPassword(model.getPassword());
		mapper.setAddedOn(model.getAddedOn());
		mapper.setUpdatedOn(model.getUpdatedOn());
		
		return mapper;
}
}
