package com.revature.ers.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ers_rejected_reimbursement_entity")
public class RejectedReimbursementEntity {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="rejected_id")
		private Integer rejectedId;
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
		
		
		
		@Override
		public String toString() {
			return "RejectedReimbursementEntity [rejectedId=" + rejectedId + ", employeeId=" + employeeId
					+ ", reimburseType=" + reimburseType + ", daysSpent=" + daysSpent + ", reimburseAmount="
					+ reimburseAmount + ", description=" + description + ", addedOn=" + addedOn + ", managerId="
					+ managerId + ", updatedOn=" + updatedOn + "]";
		}
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

