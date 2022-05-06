package service;

import java.util.Optional;

import entity.Customer;
import persistence.Dao;
import persistence.DaoImpl;

public class CustomerServiceImpl implements CustomerService {
	private Dao dao=new DaoImpl();

	@Override
	public boolean createCustomer(Customer customer) {
		if(dao.createCustomerId(customer)>0)
			return true;
		return false;
	}

	@Override
	public Optional<Customer> checkCustomer(int customerId) {
		return dao.checkCustomer(customerId);
	}
	

}
