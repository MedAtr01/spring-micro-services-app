package org.example.inventoryservice;

import org.apache.commons.lang.RandomStringUtils;
import org.example.inventoryservice.entities.Product;
import org.example.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.Format;
import java.util.Formatter;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
@Bean
	CommandLineRunner runner(ProductRepository productRepository){
		return args->{
			for(int i =0; i<5;i++){
				Product product = new Product();
				String generatedString = RandomStringUtils.randomAlphabetic(10);
				product.setProductId(UUID.randomUUID().toString());
				product.setProductName(generatedString);
				product.setPrice(Math.random()*1000*i);
				product.setQuantity(8);
				productRepository.save(product);
			}
		};
}
}
