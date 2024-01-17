package com.example.Student.Service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Student.Entity.Student;
import com.example.Student.FeignClient.FeesClient;
import com.example.Student.Repo.StudentRepo;
import com.example.Student.Response.FeesResponse;
import com.example.Student.Response.StudentResponse;





@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Autowired
    private ModelMapper mapper;
 
   
    @Autowired
    private FeesClient feesClient;
 
    public StudentResponse getStudentById(int id) {
 
        Optional<Student> student = studentRepo.findById((long) id);
        StudentResponse studentResponse = mapper.map(student, StudentResponse.class);
 
        // Using FeignClient
        ResponseEntity<FeesResponse> feesResponse = feesClient.getFeesByStudentId(id);
        studentResponse.setFeesResponse(feesResponse.getBody());
 
        return studentResponse;
    }
}
//	public StudentEntity createStudent(StudentEntity studentEntity) {
//		return studentRepo.save(studentEntity);
//	}
//
//	public List<StudentEntity> getStudentList() {
//		return studentRepo.findAll();
//	}
//
//	public StudentEntity getStudentById(Long studentId) {
//		return studentRepo.findById(studentId).orElse(null);
//
//	}
//
//	public StudentEntity updateStudent(Long id, StudentEntity studentEntity) {
//
//		return studentRepo.save(studentEntity);
//	}
//
//	public StudentEntity deleteStudent(StudentEntity studentEntity) {
//		studentRepo.delete(studentEntity);
//		return studentEntity;
//	}


