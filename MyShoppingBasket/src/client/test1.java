package client;

import java.util.Optional;

import entity.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import service.ProductService;

public class test1 {

	public static void main(String[] args) {
		//Customer cTest=new Customer(1,"customer1","india","9876543210");
		CustomerService service=new CustomerServiceImpl();
		//service.createCustomer(cTest);
		/*
		 * Optional<Customer> customer=service.checkCustomer(1);
		 * if(customer.isPresent()) System.out.println("present"); else
		 * System.out.println("not there");
		 */
		ProductService productService=new ProductServiceImpl();
		productService.eachTransaction(3,1,5);
		System.out.println(productService.getTotalCost());
	}

}