package com.example.CommonDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService<StudentEntity, FeesEntity> {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private FeesClient feesClient;

    public CommonEntity getStudentInfoWithFees(String studentId) {
        StudentEntity student = (StudentEntity) studentClient.getStudentInfo(studentId);
        FeesEntity feesDetails = (FeesEntity) feesClient.getFeesDetails(studentId);
        return new CommonEntity(student, feesDetails);
    }
}


