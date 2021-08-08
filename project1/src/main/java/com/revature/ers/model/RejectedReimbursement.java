package com.revature.ers.model;

public class RejectedReimbursement {
	
	private Integer rejectedId;
	private Integer employeeId;
	private String reimburseType;
	private Integer daysSpent;
	private Integer reimburseAmount;
	private String description="";
	private String addedOn;
	private Integer managerId=-1;
	private String updatedOn="";
	
	
	public Integer getRejectedId() {
		return rejectedId;
	}
	public void setRejectedId(Integer rejectedId) {
		this.rejectedId = rejectedId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getReimburseType() {
		return reimburseType;
	}
	public void setReimburseType(String reimburseType) {
		this.reimburseType = reimburseType;
	}
	public Integer getDaysSpent() {
		return daysSpent;
	}
	public void setDaysSpent(Integer daysSpent) {
		this.daysSpent = daysSpent;
	}
	public Integer getReimburseAmount() {
		return reimburseAmount;
	}
	public void setReimburseAmount(Integer reimburseAmount) {
		this.reimburseAmount = reimburseAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	
}
