package com.boa.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customer.models.Customer;
import com.boa.customer.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	//insert
	public Customer addCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	//select all
	public List<Customer> getAllCustomers()
	{
		return this.customerRepository.findAll();
	}
	
	//get customer by id
	
	public Customer getCustomerById(long customerId)
	{
		return this.customerRepository.findById(customerId).orElse(null);
	}
	
	//delete the customer
	
	public boolean deleteCustomerById(long customerId)
	{
		 boolean status=true;
		 this.customerRepository.deleteById(customerId);
		 if(getCustomerById(customerId)!=null)
			 status=false;
		 return status;
			  
	}
	
	//must pass customerId
	
	public Customer updateCustomer(Customer customer)
	{
		return this.customerRepository.save(customer);
	}
	

}
