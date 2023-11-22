package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SBMSProj01EurekaServerByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01EurekaServerByNTRZApplication.class, args);
	}

}
