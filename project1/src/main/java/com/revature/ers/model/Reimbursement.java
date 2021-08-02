package com.revature.ers.model;

public class Reimbursement {
	Integer reimburseId;
	Integer employeeId;
	String reimburseType;
	Integer daysSpent;
	Integer reimburseAmount;
	String description;
	String dateOfApplied;
	String status;
	Integer managerId;
	String updatedOn;
	public Reimbursement() {}
	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", employeeId=" + employeeId + ", reimburseType="
				+ reimburseType + ", daysSpent=" + daysSpent + ", reimburseAmount=" + reimburseAmount + ", description="
				+ description + ", dateOfApplied=" + dateOfApplied + ", status=" + status + ", managerId=" + managerId
				+ ", updatedOn=" + updatedOn + "]";
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
	public String getDateOfApplied() {
		return dateOfApplied;
	}
	public void setDateOfApplied(String dateOfApplied) {
		this.dateOfApplied = dateOfApplied;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
