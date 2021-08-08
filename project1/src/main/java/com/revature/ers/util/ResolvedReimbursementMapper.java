package com.revature.ers.util;


import com.revature.ers.model.ResolvedReimbursement;

public class ResolvedReimbursementMapper {
	public static ResolvedReimbursementEntity mapModelEntity(ResolvedReimbursement model) {
		ResolvedReimbursementEntity mapper=new ResolvedReimbursementEntity();
		mapper.setResolvedId(model.getResolvedId());
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
