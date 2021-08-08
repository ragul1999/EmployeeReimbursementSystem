package com.revature.ers.model;


//it is just a utility class not a pojo class
public class ReimbursementEmployee {
	private Integer statusId;
	private Integer reimburseId;
	private Integer employeeId;
	private String reimburseType;
	private Integer daysSpent;
	private Integer reimburseAmount;
	private String description="";
	private String status;
	private String addedOn;
	private Integer managerId=-1;//default, to notify that manager doesn't update/modify a particular reimbursement request
	private String updatedOn="";//default
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public Integer getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(String addedOn) {
		this.addedOn = addedOn;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
	
	
}
