package cn.aichange.util;

import java.io.Serializable;

public class Condition implements Serializable{
	//通用的查询条件
	private String name;
	private String phone;
	private String email;
	
	//部门的查询条件
	private String remarks;
	
	//员工的查询条件
	private Integer deptId;
	private String pwd;
	
	//customer的查询条件
	private String address;
	private Integer traceStatus;
		
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getTraceStatus() {
		return traceStatus;
	}
	public void setTraceStatus(Integer traceStatus) {
		this.traceStatus = traceStatus;
	}
	
	
}
