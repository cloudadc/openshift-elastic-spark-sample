package com.redhat.sample.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.redhat.sample.model.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

	public Customer findByFirstName(String firstName);
	
	public List<Customer> findByLastName(String lastName);
}
