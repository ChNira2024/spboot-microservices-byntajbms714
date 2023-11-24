package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class SBMSProj01HystrixDashBoardCircuitBrkTicketBookServiceByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01HystrixDashBoardCircuitBrkTicketBookServiceByNTRZApplication.class, args);
	}

}
