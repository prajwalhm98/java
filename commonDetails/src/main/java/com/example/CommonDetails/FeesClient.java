package com.example.CommonDetails;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "fees-service", url = "http://fees-service-url")
public interface FeesClient<FeesEntity> {

    @GetMapping("/fees/{studentId}")
    FeesEntity getFeesDetails(@PathVariable("studentId") String studentId);
}

