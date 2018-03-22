package com.redhat.sample;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.redhat.sample.model.Customer;
import com.redhat.sample.model.Success;
import com.redhat.sample.repository.CustomerRepository;


/**
 * 
 * @author kylin
 *
 */
@RestController
public class RestServiceController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
    private CustomerRepository repository;

	@RequestMapping("/rest/ping")
    public Success greeting() {
        return new Success(counter.getAndIncrement(), "Success!");
    }
	
	@RequestMapping("/rest/findAll")
    public List<Customer> findAll() {
        return Lists.newArrayList(repository.findAll());
    }
	
	@RequestMapping("/rest/findByFirstName/{name}")
    public Customer findByFirstName(@PathVariable("name")String name) {
        return repository.findByFirstName(name);
    }
	
	@RequestMapping("/rest/findByLastName/{name}")
    public List<Customer> findByLastName(@PathVariable("name")String name) {
        return repository.findByLastName(name);
    }
	
	


	
	
}
