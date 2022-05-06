package persistence;

import java.util.Optional;

import entity.Customer;

public interface Dao {
	int createCustomerId(Customer newCustomer);
	Optional<Customer> checkCustomer(int customerId);
	
}