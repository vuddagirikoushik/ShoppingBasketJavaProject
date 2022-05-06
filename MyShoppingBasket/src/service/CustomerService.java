package service;

import java.util.Optional;

import entity.Customer;

public interface CustomerService {

	boolean createCustomer(Customer customer);
	Optional<Customer> checkCustomer(int customerId);

	

}
