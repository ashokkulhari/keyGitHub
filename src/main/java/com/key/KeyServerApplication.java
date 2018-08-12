package com.key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class KeyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyServerApplication.class, args);
	}
}
