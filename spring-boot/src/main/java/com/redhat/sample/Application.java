package com.redhat.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redhat.sample.model.Customer;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    private CustomerRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		this.repository.deleteAll();
		saveCustomers();
		fetchAllCustomers();
        fetchIndividualCustomers();
	}

	private void saveCustomers() {

		this.repository.save(new Customer("Kylin", "Soong"));
		this.repository.save(new Customer("RedHat", "China"));
	}

	private void fetchAllCustomers() {
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
		
	}

	private void fetchIndividualCustomers() {

		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Smith")) {
			System.out.println(customer);	
		}
	}
}
