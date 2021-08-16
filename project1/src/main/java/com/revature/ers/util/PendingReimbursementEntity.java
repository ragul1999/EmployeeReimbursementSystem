package com.revature.ers.util;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ers_pending_reimbursement_entity")
public class PendingReimbursementEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pending_id")
	private Integer pendingId;
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="reimburse_type")
	private String reimburseType;
	@Column(name="days_spent")
	private Integer daysSpent;
	@Column(name="reimburse_amount")
	private Integer reimburseAmount;
	private String description="";
	@Column(name="added_on")
	private String addedOn;
	@Column(name="manager_id")
	private Integer managerId=-1;
	@Column(name="updated_on")
	private String updatedOn="";
	
	
	
	
	public Integer getPendingId() {
		return pendingId;
	}
	public void setPendingId(Integer pendingId) {
		this.pendingId = pendingId;
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
