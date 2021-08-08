package com.revature.ers.model;

import java.util.List;

public class Reimbursement {
	private Integer reimburseId;
	private Integer employeeId;
	private List<Reimbursement> reimbursementList;
	
	
	public void setAllReimbursement(List<Reimbursement> list) {
		reimbursementList=list;
	}
	public List<Reimbursement> getAllReimbursement(){
		return reimbursementList;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
	}
	
	
	
}
