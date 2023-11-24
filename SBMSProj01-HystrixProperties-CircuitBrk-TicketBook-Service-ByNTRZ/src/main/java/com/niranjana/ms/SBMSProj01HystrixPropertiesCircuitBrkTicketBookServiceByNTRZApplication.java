package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class SBMSProj01HystrixPropertiesCircuitBrkTicketBookServiceByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01HystrixPropertiesCircuitBrkTicketBookServiceByNTRZApplication.class, args);
	}

}
