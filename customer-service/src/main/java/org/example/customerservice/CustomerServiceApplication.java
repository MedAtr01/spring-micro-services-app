package org.example.customerservice;

import org.apache.commons.lang.RandomStringUtils;
import org.example.customerservice.entities.Customer;
import org.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.random.RandomGenerator;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args->{
			for(int i =0;i<5;i++){
				Customer customer = new Customer();
				String generatedString = RandomStringUtils.randomAlphabetic(10);
				customer.setCustomerName(generatedString);
				customer.setEmail(generatedString+"@gmail.com");
				customerRepository.save(customer);
			}
		};
}
}
