package com.cabhow.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabhow.rest.model.Customer;
import com.cabhow.rest.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("v1/")
public class CustomerController {

	@Autowired
	CustomerService service;

	@GetMapping("/getAllCustomers")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", response = List.class, produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		ResponseEntity<List<Customer>> respEntity = null;
		List<Customer> allCustomers = service.getAllCustomers();
		respEntity = ResponseEntity.ok().body(allCustomers);
		return respEntity;
	}

	@GetMapping("/getCustomerById/{id}")
	@ApiOperation(tags = "cabhow-bookings", value = "cabhow-bookings", response = List.class, produces = "application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") long id) {
		ResponseEntity<Customer> respEntity = null;
		Customer customer = service.getCustomerById(id);
		respEntity = ResponseEntity.ok().body(customer);
		return respEntity;
	}
}
