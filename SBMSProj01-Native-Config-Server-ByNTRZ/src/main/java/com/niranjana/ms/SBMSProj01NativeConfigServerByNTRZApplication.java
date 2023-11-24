package com.niranjana.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SBMSProj01NativeConfigServerByNTRZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSProj01NativeConfigServerByNTRZApplication.class, args);
	}

}
