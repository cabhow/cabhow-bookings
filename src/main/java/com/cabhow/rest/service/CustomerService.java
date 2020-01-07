package com.cabhow.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabhow.rest.exception.ResourceNotFoundException;
import com.cabhow.rest.model.Customer;
import com.cabhow.rest.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository repository;

	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = repository.findAll();
		return allCustomers;
	}

	public Customer getCustomerById(long id) {
		Customer fetchedCustomer = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		return fetchedCustomer;
	}
	
}
