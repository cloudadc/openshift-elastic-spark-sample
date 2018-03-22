package com.redhat.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.redhat.sample.model.Customer;
import com.redhat.sample.repository.CustomerRepository;

/**
 * 
 * https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html
 * 
 *   docker run -p 9200:9200 -p 9300:9300  docker.io/elasticsearch:2.4.6
 * 
 * REST API:
 *     /rest/findAll
 *     /rest/findByFirstName/Kylin
 *     /rest/findByLastName/Soong
 * 
 * @author kylin
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    
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

		System.out.println("Customer found with findByFirstName('Kylin'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Kylin"));

		System.out.println("Customers found with findByLastName('Soong'):");
		System.out.println("--------------------------------");
		for (Customer customer : this.repository.findByLastName("Soong")) {
			System.out.println(customer);	
		}
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
