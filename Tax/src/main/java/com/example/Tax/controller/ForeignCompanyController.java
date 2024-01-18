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

import com.example.Tax.Repository.ForeignCompanyRepository;
import com.example.Tax.Repository.Section115BAARepository;
	import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.Service.ForeignCompanyService;
import com.example.Tax.Service.Section115BAAService;
	import com.example.Tax.Service.Section115BABService;
import com.example.Tax.model.ForeignCompanyTax;
import com.example.Tax.model.Section115BAA;
	import com.example.Tax.model.Section115BAB;
	@CrossOrigin(origins ="*")
	@RestController
	@RequestMapping("/ForeignCompanyTax")
	public class ForeignCompanyController {
		@Autowired
		 private ForeignCompanyService foreignCompanyService;
		
		@Autowired
		private ForeignCompanyRepository foreignCompnayRepository;
		
		 @GetMapping("/getAll")
		public List<ForeignCompanyTax> getAllForeignCompanyTax() {
			return foreignCompanyService.getAllForeignCompanyTax();
		}
		 @GetMapping("/getid")
		 public ForeignCompanyTax getForeignCompanyTaxById(@PathVariable Long id) {
			 return foreignCompanyService.getForeignCompnayTaxById(id);
	   }
		 
		 @PostMapping("/income")
		 public ForeignCompanyTax createForeignCompany(@RequestBody ForeignCompanyTax ForeignCompany) {
			 return foreignCompanyService.createForeignCompanyTax(ForeignCompany);
		 }
		 
		 @PutMapping("/{id}")
		 public ForeignCompanyTax updateForeignCompanyTax(@PathVariable Long id, @RequestBody  ForeignCompanyTax ForeignCompanyTaxDetails) {
			 return foreignCompanyService.updateForeignCompany(id, ForeignCompanyTaxDetails);
		 }
		 
		 @DeleteMapping("/delete/{id}")
		 public ResponseEntity<?> deleteForeignCompanyTax(@PathVariable Long id) {
			 foreignCompanyService.deleteForeignCompanyTax(id);
			 return ResponseEntity.ok().build();
		 }
		 @PostMapping("/tax")
			public ForeignCompanyTax calculateTax(@RequestBody ForeignCompanyTax ForeignCompanyTax) {
			    return foreignCompanyService.calculateTax(ForeignCompanyTax);
			}
	}


