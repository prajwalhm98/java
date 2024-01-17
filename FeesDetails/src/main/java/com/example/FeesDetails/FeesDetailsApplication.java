package com.example.FeesDetails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeesDetailsApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(FeesDetailsApplication.class, args);
		
		
	}

}
