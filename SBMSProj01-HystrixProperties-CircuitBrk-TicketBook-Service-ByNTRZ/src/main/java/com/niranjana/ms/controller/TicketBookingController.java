//TicketBookingController.java
package com.niranjana.ms.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController 
{

	@GetMapping("/booking")
	/*@HystrixCommand(fallbackMethod = "dummyBookTickets",
	                                        commandProperties = { @HystrixProperty(name="circuitBreaker.enabled", value="true")       })*/
	
	@HystrixCommand(fallbackMethod = "dummyBookTickets",
                    commandProperties = { @HystrixProperty(name="circuitBreaker.enabled", value="true"), //intial circuit breaker is opened.Default is false
                                          @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="5"), //Default exce is 20.for every 5 bad request,
                                          @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000")//it will sleep for 7second,after that it will go to dummyMethod
                                         }
	                )
	
	public  String   bookTickets() 
	{
		System.out.println("TicketBookingController.bookTickets()");
		if( new Random().nextInt(10)<6) 
			throw new IllegalArgumentException("problem in ticket booking");
			
			return "Tickets booked sucessfully";
	}//method
	
	int count=0;
	public  String dummyBookTickets() 
	{   // this method should not have params
		 count++;
		System.out.println("TicketBookingController.dummyBookTickets()"+count);
		return " Sorry for inconvience .... some problem in ticket booking";
	}
	
}//class
//Hystrix is deprecated,used upto spring boot <2.4v	only.Onwards no use
