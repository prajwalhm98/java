package com.example.CommonDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")

public class CommonController {

    @Autowired
    private CommonService studentFeesService;

    @GetMapping("/students/{studentId}/fees")
    public CommonEntity getStudentInfoWithFees(@PathVariable String studentId) {
        return studentFeesService.getStudentInfoWithFees(studentId);
    }
}


