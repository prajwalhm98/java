package com.example.Student.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Student.Response.FeesResponse;



	@FeignClient(name = "fees-service", url = "http://localhost:8087", path = "/fees-service")
	public interface FeesClient {
	 
	    @GetMapping("/fees/{id}")
	    public ResponseEntity<FeesResponse> getFeesByStudentId(@PathVariable("id") int id);
	 
	}

