package com.example.Tax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tax.Repository.Section115BAARepository;
import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.Service.Section115BAAService;
import com.example.Tax.Service.Section115BABService;
import com.example.Tax.model.Section115BAA;
import com.example.Tax.model.Section115BAB;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/115BAA")
public class Section115BAAController {
	@Autowired
	 private Section115BAAService section115BAAService;
	
	@Autowired
	private Section115BAARepository section115BAARepository;
	
	 @GetMapping("/getAll")
	public List<Section115BAA> getAllSection115BAA() {
		return section115BAAService.getAllSection115BAA();
	}
	 @GetMapping("/getid")
	 public Section115BAA getSection115BAAById(@PathVariable Long id) {
		 return section115BAAService.getSection115BAAById(id);
   }
	 
	 @PostMapping("/income")
	 public Section115BAA createSection115BAA(@RequestBody Section115BAA Section115BAA) {
		 return section115BAAService.createSection115BAA(Section115BAA);
	 }
	 
	 @PutMapping("/{id}")
	 public Section115BAA updateSection115BAA(@PathVariable Long id, @RequestBody Section115BAA Section115BAADetails) {
		 return section115BAAService.updateSection115BAA(id, Section115BAADetails);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<?> deleteSection115BAA(@PathVariable Long id) {
		 section115BAAService.deleteSection115BAA(id);
		 return ResponseEntity.ok().build();
	 }
	 @PostMapping("/tax")
		public Section115BAA calculateTax(@RequestBody Section115BAA Section115BAA) {
		    return section115BAAService.calculateTax(Section115BAA);
		}
}
