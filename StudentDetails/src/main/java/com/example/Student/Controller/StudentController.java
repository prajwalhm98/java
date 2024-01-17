package com.example.Student.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Response.StudentResponse;
import com.example.Student.Service.StudentService;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	 @GetMapping("/student/{id}")
	    private ResponseEntity<StudentResponse> getStudentDetails(@PathVariable("id") int id) {
	        StudentResponse student = studentService.getStudentById(id);
	        return ResponseEntity.status(HttpStatus.OK).body(student);
	    }
	 

//	@PostMapping("/createStudent")
//	public StudentEntity createStudent(@RequestBody StudentEntity student) {
//		return studentService.createStudent(student);
//	}
//
//	@GetMapping("/getStudents")
//	public List<StudentEntity> getAllStudents() {
//		return studentService.getStudentList();
//	}
//
//	@GetMapping("/{studentId}")
//	public StudentEntity getStudentById(@PathVariable Long studentId) {
//		return studentService.getStudentById(studentId);
//	}
//
//	@PutMapping("/{id}")
//	public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity StudentDetails) {
//		return studentService.updateStudent(id, StudentDetails);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public StudentEntity deleteStudent(@PathVariable Long id, @RequestBody StudentEntity StudentDetails) {
//		return studentService.deleteStudent(StudentDetails);
//
//	}
}
