package com.niranjana.ms.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Billing-Service")
public interface IBillingServiceRestConsumerUsingFeignClient 
{

	@GetMapping("/billing/info")
	public String fetchBillDetails();//here i am fetching producer API.Here we can take diff. method name but signature must be same as producer api call method signature
	
	@GetMapping("/billing/dbuser/externalconfig")
	public String fetchDBUserDetailsFromProducer();
	
}//class

//FeignClient  is abstract client because internally InMemory proxy class generated for @FeignClient interface will take of getting service
//instance and making http calls
//only one dependency i.e FeignClient
//FeignClient support Load Balancing