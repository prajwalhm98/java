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
import com.example.Tax.Service.IncomeTaxService;
import com.example.Tax.model.IncomeTax;
@CrossOrigin(origins ="*")
	@RestController
	@RequestMapping("/api")
	public class IncomeTaxController {
		
		@Autowired
		 private IncomeTaxService taxService;
		
		@Autowired
		private IncomeTaxRepository incomeTaxRepository;
		
		 @GetMapping("/getAll")
		public List<IncomeTax> getAllIncomes() {
			return taxService.getAllIncomes();
		}
		 @GetMapping("/getid")
		 public IncomeTax getIncomeById(@PathVariable Long id) {
			 return taxService.getIncomeById(id);
	     }
		 
		 @PostMapping("/income")
		 public IncomeTax createIncome(@RequestBody IncomeTax income) {
			 return taxService.createIncome(income);
		 }
		 
		 @PutMapping("/{id}")
		 public IncomeTax updateIncome(@PathVariable Long id, @RequestBody IncomeTax incomeDetails) {
			 return taxService.updateIncome(id, incomeDetails);
		 }
		 
		 @DeleteMapping("/delete/{id}")
		 public ResponseEntity<?> deleteIncome(@PathVariable Long id) {
			 taxService.deleteIncome(id);
			 return ResponseEntity.ok().build();
		 }
		 @PostMapping("/tax")
			public IncomeTax calculateTax(@RequestBody IncomeTax income ) {
			    return taxService.calculateTax(income);
			}
	}
	
