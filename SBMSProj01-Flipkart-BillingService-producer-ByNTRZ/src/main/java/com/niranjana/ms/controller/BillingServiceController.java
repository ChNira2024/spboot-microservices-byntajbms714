package com.niranjana.ms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
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
		return "we accept   Card Payment , UPI Payment,  NetBaking Payment, COD---> port::"+port+"----InstanceId::"+instanceId;		
	}

	@GetMapping("/dbuser/externalconfig")
	public  String   showDBUserDataExConfig() 
	{
		  return  "(Employee)Data Collected throgh Config Server ::"+dbuser+"----"+password;
	}
	
	@GetMapping("/dbuser/nativeconfig")
	public  String   showDBUserDataNativeConfig() 
	{
		  return  "(Employee)Data Collected throgh Config Server ::"+dbuser+"----"+password;
	}
}
