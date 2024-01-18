package com.example.Tax.controller;

	import java.util.List;
import java.util.Optional;

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
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

import com.example.Tax.Repository.IncomeTaxRepository;
import com.example.Tax.Repository.Section115BARepository;
import com.example.Tax.Service.IncomeTaxService;
import com.example.Tax.Service.Section115BAService;
import com.example.Tax.model.IncomeTax;
import com.example.Tax.model.Section115BA;
@CrossOrigin(origins ="*")
	@RestController
	@RequestMapping("/115BA")
	public class Section115BAController {
		
		@Autowired
		 private Section115BAService section115BAService;
		
		@Autowired
		private Section115BARepository section115BARepository;
		
		 @GetMapping("/getAll")
		public List<Section115BA> getAllSection115BA() {
			return section115BAService.getAllSection115BA();
		}
		 @GetMapping("/getid")
		 public Section115BA getSection115BAById(@PathVariable Long id) {
			 return section115BAService.getSection115BAById(id);
	     }
		 
		 @PostMapping("/income")
		 public Section115BA createSection115BA(@RequestBody Section115BA Section115BA) {
			 return section115BAService.createSection115BA(Section115BA);
		 }
		 
		 @PutMapping("/{id}")
		 public Section115BA updateSection115BA(@PathVariable Long id, @RequestBody Section115BA Section115BADetails) {
			 return section115BAService.updateSection115BA(id, Section115BADetails);
		 }
		 
		 @DeleteMapping("/delete/{id}")
		 public ResponseEntity<?> deleteSection115BA(@PathVariable Long id) {
			 section115BAService.deleteSection115BA(id);
			 return ResponseEntity.ok().build();
		 }
		 @PostMapping("/tax")
			public Section115BA calculateTax(@RequestBody Section115BA Section115BA) {
			    return section115BAService.calculateTax(Section115BA);
			}
	}
	


