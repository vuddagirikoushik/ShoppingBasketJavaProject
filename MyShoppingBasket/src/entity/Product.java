package entity;

public class Product {
	private int productId;
	private String productName;
	private int noOfItems;
	private double price;
	private int salesTax;
	public Product(int productId, String productName, int noOfItems, double price, int salesTax) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.noOfItems = noOfItems;
		this.price = price;
		this.salesTax = salesTax;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(int salesTax) {
		this.salesTax = salesTax;
	}
		


}
