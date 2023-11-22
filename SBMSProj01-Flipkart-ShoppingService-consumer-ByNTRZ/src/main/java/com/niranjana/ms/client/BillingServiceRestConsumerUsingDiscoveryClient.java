package com.niranjana.ms.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumerUsingDiscoveryClient 
{
	
	@Autowired
	private  DiscoveryClient  client;  //it is pre-define interface.comes through  AutoConfiguration
	
	public  String  getBillingInfo() 
	{
		  //find and get SErviceInstances  of Producer by using Service Id(ServiceId/ServiceName both r same)
		 List<ServiceInstance>  listSI=client.getInstances("Billing-Service");
		 
		 // use  first ServiceInstance from the List of Instances
		  ServiceInstance  SI = listSI.get(0);
		  
		  //get Producer MS URI(Universal resource indicator)  and make it  as URL
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
//Discovery Client call getInstances() to get service instance and use RestTemplate to make http calls.
//only one dependency i.e DiscoveryClient
//DiscoveryClient does not support Load Balancing