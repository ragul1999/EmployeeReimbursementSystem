package com.revature.ers.util;

import com.revature.ers.model.RejectedReimbursement;

public class RejectedReimbursementMapper {
	public static RejectedReimbursementEntity mapModelEntity(RejectedReimbursement model) {
		RejectedReimbursementEntity mapper=new RejectedReimbursementEntity();
		mapper.setRejectedId(model.getRejectedId());
		mapper.setEmployeeId(model.getEmployeeId());
		mapper.setDaysSpent(model.getDaysSpent());
		mapper.setReimburseType(model.getReimburseType());
		mapper.setReimburseAmount(model.getReimburseAmount());
		mapper.setDescription(model.getDescription());
		mapper.setAddedOn(model.getAddedOn());
		mapper.setManagerId(model.getManagerId());
		mapper.setUpdatedOn(model.getUpdatedOn());
		return mapper;

	}
}
