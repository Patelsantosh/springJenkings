package com.shop.myProducts;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProductsApplication.class, args);
	}

	 @Bean
	    public ModelMapper modelMapperBean() {
	        return new ModelMapper();
	    }
	 
}
