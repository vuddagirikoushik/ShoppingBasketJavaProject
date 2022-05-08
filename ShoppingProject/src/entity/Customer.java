package entity;


public class Customer {
	private int customerId;
	private String customerName;
	private String address;
	private String customerNumber;
	private String password;
	
	public Customer(int customerId, String customerName, String address, String customerNumber, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.customerNumber = customerNumber;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
