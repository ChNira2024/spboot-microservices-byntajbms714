package com.niranjana.ms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
@RefreshScope  
public class BillingServiceController 
{
	
	 @Value("${server.port}")
	 private  int  port;
	
	 @Value("${eureka.instance.instance-id}")
	 private String  instanceId; 
	 
	 @Value("${dbuser}")
	 private  String  dbuser;
	 
	@Value("${dbpwd}")
	private String password;
	
	@GetMapping("/info")
	public  String   getBillingInfo() 
	{
		System.out.println("BillingServiceController.getBillingInfo()");
		return "we accept   Card Payment , UPI Payment,  NetBaking Payment, COD---> port::"+port+"----InstanceId::"+instanceId;		
	}

	@GetMapping("/dbuser/externalconfig")
	public  String   showDBUserDataExConfig() 
	{
		System.out.println("BillingServiceController.showDBUserDataExConfig()");
		  return  "(Employee)Data Collected throgh Config Server ::"+dbuser+"----"+password;
	}
	
	@GetMapping("/dbuser/nativeconfig")
	public  String   showDBUserDataNativeConfig() 
	{
		System.out.println("BillingServiceController.showDBUserDataNativeConfig()");
		  return  "(Employee)Data Collected throgh Config Server ::"+dbuser+"----"+password;
	}
}

//@RefreshScope:it used for when we did modification in github-config file it will directly reflect otherwise need to start Config Server application
//for RefreshScope , u need to add dependency: "spring-boot-starter-actuator" in pom.xml
