package com.example.FeesDetails.FeesController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.FeesDetails.FeesService.FeesService;
import com.example.FeesDetails.Response.FeesResponse;





@RestController
public class FeesController {
   
	
	@Autowired
	private FeesService feesService;
	

	 @GetMapping("/fees/{studentId}")
	    public ResponseEntity<FeesResponse> getFeesByStudentId(@PathVariable("studentId") int studentId) {
	        FeesResponse feesResponse = feesService.findFeesByStudentId(studentId);
	        return ResponseEntity.status(HttpStatus.OK).body(feesResponse);
	    }
	 

//	@PostMapping("/FeesDetails")
//	public FeesEntity createFeesDetails(@RequestBody FeesEntity Fees) {
//		return FeesService.createFeesDetails(Fees);
//	}
//
//	@GetMapping("/getFees")
//	public List<FeesEntity> getAllFeesDetails() {
//		return FeesService.getFeesDetailsList();
//	}
//
//	@GetMapping("/{FeesId}")
//	public FeesEntity getFeesDetailsById(@PathVariable Long studentId) {
//		return FeesService.getFeesDetailsById(studentId);
//	}
//
//	@PutMapping("/{id}")
//	public FeesEntity updateFeesDetails(@PathVariable Long id, @RequestBody FeesEntity StudentDetails) {
//		return FeesService.updateFeesDetails(id, StudentDetails);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public FeesEntity deleteFeesDetails(@PathVariable Long id, @RequestBody FeesEntity StudentDetails) {
//		return FeesService.deleteFeesDetails(StudentDetails);
//
//	}
}