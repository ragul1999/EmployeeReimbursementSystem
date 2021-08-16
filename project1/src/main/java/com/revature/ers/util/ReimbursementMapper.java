package com.revature.ers.util;


import com.revature.ers.model.Reimbursement;

public class ReimbursementMapper {
	public static ReimbursementEntity  mapModelEntity(Reimbursement model) {
		ReimbursementEntity mapper=new ReimbursementEntity();
		mapper.setReimburseId(model.getReimburseId());
		EmployeeEntity empEntity=new EmployeeEntity();
		empEntity.setEmployeeId(model.getEmployeeId());
		mapper.setEmployeeId(empEntity);
		
		
		return mapper;
	}
	
	

}
