package com.application.bean;

public class CustomerBean {

	private Integer customerId;
	private String customerName;
	private String phoneno;
	private Double salary;
	
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerBean(Integer customerId, String customerName, String phoneno, Double salary) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneno = phoneno;
		this.salary = salary;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", customerName=" + customerName + ", phoneno=" + phoneno
				+ ", salary=" + salary + "]";
	}
	
	
	
}
