package com.revature.ers.util;

import com.revature.ers.model.Reimbursement;

public class ReimbursementMapper {
	public static ReimbursementEntity  mapModelEntity(Reimbursement model) {
		ReimbursementEntity mapper=new ReimbursementEntity();
		mapper.setReimburseId(model.getReimburseId());
		mapper.setEmployeeId(model.getEmployeeId());
		
		
		return mapper;
	}
	
	

}
