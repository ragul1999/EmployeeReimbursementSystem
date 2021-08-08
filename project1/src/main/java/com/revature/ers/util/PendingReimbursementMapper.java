package com.revature.ers.util;

import com.revature.ers.model.PendingReimbursement;

public class PendingReimbursementMapper {
	public static PendingReimbursementEntity mapModelEntity(PendingReimbursement model) {
		PendingReimbursementEntity mapper=new PendingReimbursementEntity();
		
		mapper.setPendingId(model.getPendingId());
		mapper.setEmployeeId(model.getEmployeeId());
		mapper.setReimburseType(model.getReimburseType());
		mapper.setDaysSpent(model.getDaysSpent());
		mapper.setReimburseAmount(model.getReimburseAmount());
		mapper.setDescription(model.getDescription());
		mapper.setAddedOn(model.getAddedOn());
		mapper.setManagerId(model.getManagerId());
		mapper.setUpdatedOn(model.getUpdatedOn());
		return mapper;
	}
}
