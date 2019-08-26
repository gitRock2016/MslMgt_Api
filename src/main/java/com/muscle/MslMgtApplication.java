package com.muscle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// same as @Configuration @EnableAutoConfiguration @ComponentScan
// https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#getting-started-first-application-annotations
@SpringBootApplication
public class MslMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslMgtApplication.class, args);
	}

}
