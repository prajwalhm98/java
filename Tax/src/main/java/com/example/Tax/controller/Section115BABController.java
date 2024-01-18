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

import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.Repository.Section115BARepository;
import com.example.Tax.Service.Section115BABService;
import com.example.Tax.Service.Section115BAService;
import com.example.Tax.model.Section115BA;
import com.example.Tax.model.Section115BAB;
@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/115BAB")
public class Section115BABController {
	@Autowired
	 private Section115BABService section115BABService;
	
	@Autowired
	private Section115BABRepository section115BABRepository;
	
	 @GetMapping("/getAll")
	public List<Section115BAB> getAllSection115BAB() {
		return section115BABService.getAllSection115BAB();
	}
	 @GetMapping("/getid")
	 public Section115BAB getSection115BABById(@PathVariable Long id) {
		 return section115BABService.getSection115BABById(id);
    }
	 
	 @PostMapping("/income")
	 public Section115BAB createSection115BAB(@RequestBody Section115BAB Section115BAB) {
		 return section115BABService.createSection115BAB(Section115BAB);
	 }
	 
	 @PutMapping("/{id}")
	 public Section115BAB updateSection115BAB(@PathVariable Long id, @RequestBody Section115BAB Section115BABDetails) {
		 return section115BABService.updateSection115BAB(id, Section115BABDetails);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<?> deleteSection115BAB(@PathVariable Long id) {
		 section115BABService.deleteSection115BAB(id);
		 return ResponseEntity.ok().build();
	 }
	 @PostMapping("/tax")
		public Section115BAB calculateTax(@RequestBody Section115BAB Section115BAB) {
		    return section115BABService.calculateTax(Section115BAB);
		}
}
