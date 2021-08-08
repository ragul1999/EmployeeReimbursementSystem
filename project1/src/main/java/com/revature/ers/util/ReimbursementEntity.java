package com.revature.ers.util;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ers_reimbursement_entity")
public class ReimbursementEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reimburse_id")
	private Integer reimburseId;
	@Column(name="employee_id")
	private Integer employeeId;
	
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=PendingReimbursementEntity.class)
	@JoinColumn(name="pending_id")
	private PendingReimbursementEntity pendingId;
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=ResolvedReimbursementEntity.class)
	@JoinColumn(name="resolved_id")
	private ResolvedReimbursementEntity resolvedId; 
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=RejectedReimbursementEntity.class)
	@JoinColumn(name="rejected_id")
	private RejectedReimbursementEntity rejectedId;
	

	
	@Override
	public String toString() {
		return "ReimbursementEntity [reimburseId=" + reimburseId + ", employeeId=" + employeeId + ", pendingId="
				+ pendingId + ", resolvedId=" + resolvedId + ", rejectedId=" + rejectedId + "]";
	}
	public PendingReimbursementEntity getPendingId() {
		return pendingId;
	}
	public void setPendingId(PendingReimbursementEntity pendingId) {
		this.pendingId = pendingId;
	}
	public ResolvedReimbursementEntity getResolvedId() {
		return resolvedId;
	}
	public void setResolvedId(ResolvedReimbursementEntity resolvedId) {
		this.resolvedId = resolvedId;
	}
	public RejectedReimbursementEntity getRejectedId() {
		return rejectedId;
	}
	public void setRejectedId(RejectedReimbursementEntity rejectedId) {
		this.rejectedId = rejectedId;
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

	
	
}
