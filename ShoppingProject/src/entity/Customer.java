package entity;


public class Customer {
	private int customerId;
	private String customerName;
	private String address;
	private String customerNumber;
	public Customer(int customerId, String customerName, String address, String customerNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.customerNumber = customerNumber;
		
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	

}
