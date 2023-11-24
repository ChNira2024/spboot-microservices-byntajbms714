package com.niranjana.ms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niranjana.ms.client.BillingServiceRestConsumerUsingDiscoveryClient;
import com.niranjana.ms.client.BillingServiceRestConsumerUsingLoadBalancerClient;
import com.niranjana.ms.client.IBillingServiceRestConsumerUsingFeignClient;

@RestController
@RequestMapping("/shopping")
@RefreshScope 
public class ShoppingController 
{
	@Autowired
	private BillingServiceRestConsumerUsingDiscoveryClient bsrcDiscoveryClientConsumer;
	
	@Autowired
	private BillingServiceRestConsumerUsingLoadBalancerClient loadbalClientConsumer;
	
	@Autowired
	private IBillingServiceRestConsumerUsingFeignClient feignClientConsumer;
	
	@GetMapping("/info/discclient")
	public  String   getDisplayShoppingDetailsUsingDiscoClient() 
	{
		System.out.println("ShoppingController.getDisplayShoppingDetailsUsingDiscoClient()");
		System.out.println("ShoppingController.getDisplayShoppingDetailsUsingDiscoClient()");
		return  "Pongal Shopping for Family ...."+bsrcDiscoveryClientConsumer.getBillingInfo();
	}
	
	@GetMapping("/info/loadbanclient")
	public  String   getDisplayShoppingDetailsUsingLoadBalClient() 
	{
		System.out.println("ShoppingController.getDisplayShoppingDetailsUsingLoadBalClient()");
		System.out.println("ShoppingController.getDisplayShoppingDetailsUsingLoadBalClient()");
		return  "Pongal Shopping for Family ...."+loadbalClientConsumer.getBillingInfo();
	}
	
	
	@GetMapping("/info/feignclient")
	public  String   displayShoppingDetails() 
	{
		System.out.println("ShoppingController.displayShoppingDetails()");
		System.out.println("ShoppingController:: client comp class name(proxy class)::"+feignClientConsumer.getClass());
		return  "Pongal Shopping for Family ...."+feignClientConsumer.fetchBillDetails();	
	}
	
	@GetMapping("/dbuser/externalconfig/feignclient")
	public  String   displayDBuserDetails() 
	{
		System.out.println("ShoppingController.displayDBuserDetails()");
		System.out.println("ShoppingController:: client comp class name(proxy class)::"+feignClientConsumer.getClass());
		return  "Pongal Shopping for Family ...."+feignClientConsumer.fetchDBUserDetailsFromProducer();
	}

}
//@RefreshScope:it used for when we did modification in github-config file it will directly reflect otherwise need to start Config Server application
//for @RefreshScope , u need to add dependency: "spring-boot-starter-actuator" in pom.xml