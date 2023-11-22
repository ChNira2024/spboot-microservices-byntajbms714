package com.niranjana.ms.client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumerUsingLoadBalancerClient 
{
	
	@Autowired
	private  LoadBalancerClient  client;  //comes through  AutoConfiguration
	
	public  String  getBillingInfo() 
	{
		  //get Less LoadFatory Service Insntance
		  ServiceInstance  SI=client.choose("Billing-Service");
		  
		  //get Producer MS URI  and make it  as URL
		  String url=SI.getUri()+"/billing/info";
		  
		  // create RestTemplate object
		  RestTemplate  template=new RestTemplate();
		  
		  // invoke producer MS service method or operation by generating Http call
		  String  resp=template.getForObject(url,String.class);
		   return resp;
	}//method
}//class
//URI = http://localhost:9900
//URL = URI + billing/info
//LoadBalancer Client call getInstances() to get service instance and use RestTemplate to make http calls.
//only one dependency i.e DiscoveryClient
//LoadBalancer support Load Balancing