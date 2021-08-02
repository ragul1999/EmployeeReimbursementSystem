package com.revature.ers.model;

public class Employee {
	
	private Integer employeeId;
	private String password;
	private String employeeName;
	private String designation;
	private String department;
	private String email;
	private String type;
	private String addedOn;
	private String updatedOn;
	
	public Employee(){}
	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", password=" + password + ", employeeName=" + employeeName
				+ ", designation=" + designation + ", department=" + department + ", email=" + email + ", type=" + type
				+ ", addedOn=" + addedOn + ", updatedOn=" + updatedOn + "]";
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
