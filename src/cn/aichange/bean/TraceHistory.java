package cn.aichange.bean;

import java.sql.Timestamp;

/**
 * TraceHistory entity. @author MyEclipse Persistence Tools
 */

public class TraceHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Employee employee;
	private Customer customer;
	private Timestamp traceTime;
	private String traceMethod;
	private String content;
	private Integer result;

	// Constructors

	/** default constructor */
	public TraceHistory() {
	}

	/** full constructor */
	public TraceHistory(Employee employee, Customer customer,
			Timestamp traceTime, String traceMethod, String content,
			Integer result) {
		this.employee = employee;
		this.customer = customer;
		this.traceTime = traceTime;
		this.traceMethod = traceMethod;
		this.content = content;
		this.result = result;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getTraceTime() {
		return traceTime;
	}

	public void setTraceTime(Timestamp traceTime) {
		this.traceTime = traceTime;
	}

	public String getTraceMethod() {
		return traceMethod;
	}

	public void setTraceMethod(String traceMethod) {
		this.traceMethod = traceMethod;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	
}