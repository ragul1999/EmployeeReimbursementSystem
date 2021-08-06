package com.revature.ers.util;


import com.revature.ers.model.ResolvedReimbursement;

public class ResolvedReimbursementMapper {
	public static ResolvedReimbursementEntity mapModelEntity(ResolvedReimbursement model) {
		ResolvedReimbursementEntity mapper=new ResolvedReimbursementEntity();
		mapper.setReimburseId(model.getReimburseId());
		mapper.setEmployeeId(model.getEmployeeId());
		mapper.setDaysSpent(model.getDaysSpent());
		mapper.setReimburseAmount(model.getReimburseAmount());
		mapper.setDescription(model.getDescription());
		mapper.setAddedOn(model.getAddedOn());
		mapper.setManagerId(model.getManagerId());
		mapper.setUpdatedOn(model.getUpdatedOn());
		return mapper;

}
}
