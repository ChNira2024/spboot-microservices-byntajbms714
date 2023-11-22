package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SBMSProj01FlipkartShoppingServiceConsumerByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01FlipkartShoppingServiceConsumerByNTRZApplication.class, args);
	}

}
