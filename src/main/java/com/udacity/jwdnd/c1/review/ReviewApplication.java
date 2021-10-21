package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	@Bean
	String message() {
		System.out.println("@Bean message been printed out");
		return "Hello, Spring!";
	}

	@Bean
	String uppercaseMessage(MessageService messageService) {
		System.out.println("uppercaseMessage @Bean "+ messageService.upperCase());
		return messageService.upperCase();
	}

	@Bean
	String lowercaseMessage(MessageService messageService) {
		System.out.println("lowercaseMessage @Bean "+ messageService.lowerCase());
		return messageService.lowerCase();
	}

}
