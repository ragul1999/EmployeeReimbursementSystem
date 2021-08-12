package com.revature.ers.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ers_resolved_reimbursement_entity")
public class ResolvedReimbursementEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="resolved_id")
	Integer resolvedId;
	@Column(name="employee_id")
	Integer employeeId;
	@Column(name="reimburse_type")
	String reimburseType;
	@Column(name="days_spent")
	Integer daysSpent;
	@Column(name="reimburse_amount")
	Integer reimburseAmount;
	String description="";
	@Column(name="added_on")
	String addedOn;
	@Column(name="manager_id")
	Integer managerId=-1;
	@Column(name="updated_on")
	String updatedOn="";

	
	
	
	public Integer getResolvedId() {
		return resolvedId;
	}
	public void setResolvedId(Integer resolvedId) {
		this.resolvedId = resolvedId;
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
	
