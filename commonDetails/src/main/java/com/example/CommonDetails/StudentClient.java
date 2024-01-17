package com.example.CommonDetails;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name = "student-service", url = "http://student-service-url")
public interface StudentClient<StudentEntity> {

	@GetMapping("/students/{studentId}")
	StudentEntity getStudentInfo(@PathVariable("studentId") String studentId);
}
