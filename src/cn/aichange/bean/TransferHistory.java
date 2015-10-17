package cn.aichange.bean;

import java.sql.Timestamp;

/**
 * TransferHistory entity. @author MyEclipse Persistence Tools
 */

public class TransferHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Customer customer;
	private Employee employeeNew;
	private Employee employeeOld;
	private String reason;
	private Timestamp transferTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployeeNew() {
		return employeeNew;
	}
	public void setEmployeeNew(Employee employeeNew) {
		this.employeeNew = employeeNew;
	}
	public Employee getEmployeeOld() {
		return employeeOld;
	}
	public void setEmployeeOld(Employee employeeOld) {
		this.employeeOld = employeeOld;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Timestamp getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Timestamp transferTime) {
		this.transferTime = transferTime;
	}

}