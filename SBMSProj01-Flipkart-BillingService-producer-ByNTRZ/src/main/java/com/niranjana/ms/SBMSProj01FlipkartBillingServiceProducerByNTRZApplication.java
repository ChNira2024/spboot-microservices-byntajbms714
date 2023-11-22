package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SBMSProj01FlipkartBillingServiceProducerByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01FlipkartBillingServiceProducerByNTRZApplication.class, args);
	}

}
