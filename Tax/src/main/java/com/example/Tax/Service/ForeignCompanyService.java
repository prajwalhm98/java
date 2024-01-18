package com.example.Tax.Service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.example.Tax.NotFoundException.ResourceNotFoundException;
import com.example.Tax.Repository.ForeignCompanyRepository;
import com.example.Tax.Repository.Section115BAARepository;
	import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.model.ForeignCompanyTax;
import com.example.Tax.model.Section115BAA;
	import com.example.Tax.model.Section115BAB;

	@Service
	public class ForeignCompanyService {
		@Autowired
		private ForeignCompanyRepository foreignCompanyRepository;

		public List<ForeignCompanyTax> getAllForeignCompanyTax() {
			return foreignCompanyRepository.findAll();
		}

		public ForeignCompanyTax getForeignCompnayTaxById(Long id) {
			return foreignCompanyRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		}

		public ForeignCompanyTax createForeignCompanyTax(ForeignCompanyTax ForeignCompany ) {
			return foreignCompanyRepository.save(ForeignCompany);
		}

		public ForeignCompanyTax updateForeignCompany(Long id,ForeignCompanyTax ForeignCompanyTaxDetails) {
			ForeignCompanyTax ForeignCompanyTax = foreignCompanyRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
			ForeignCompanyTax.setCompanyName(ForeignCompanyTaxDetails.getCompanyName());
			ForeignCompanyTax.setCompanyIncome(ForeignCompanyTaxDetails.getCompanyIncome());
			ForeignCompanyTax.setDeductions(ForeignCompanyTaxDetails.getDeductions());
			return foreignCompanyRepository.save(ForeignCompanyTax);
		}

		public void deleteForeignCompanyTax(Long id) {
			ForeignCompanyTax ForeignCompanyTax = foreignCompanyRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
			foreignCompanyRepository.delete(ForeignCompanyTax);
		}

		private static final double CESS_RATE = 0.04;

		public ForeignCompanyTax calculateTax(ForeignCompanyTax ForeignCompanyTax) {
	        
	        String CompanyName = ForeignCompanyTax.getCompanyName();
	        
	        double CompanyIncome = ForeignCompanyTax.getCompanyIncome();
	        double Deduction = ForeignCompanyTax.getDeductions();
	       
	        
	        long tax_Payable = 0;
			long surcharge = 0;
			long Tax=0;

			long income = (long) (CompanyIncome-Deduction);
			ForeignCompanyTax.setIncome(income);
			if (income >= 2500000 && income < 10000000) {
				Tax=40;
				tax_Payable = (long) (income * 0.40);
				ForeignCompanyTax.setTax(Tax);
				ForeignCompanyTax.setTax_Payable(tax_Payable);
			} else if (income >=10000001) {
				Tax =42;
				tax_Payable = (long) (income * 0.42);
				ForeignCompanyTax.setTax(Tax);
				ForeignCompanyTax.setTax_Payable(tax_Payable);
			}
		

	                // add cess
	               long  cess = (long) (tax_Payable * CESS_RATE);
	               ForeignCompanyTax.setCess(cess);
	                tax_Payable += cess;
	                ForeignCompanyTax.setTax_Payable(tax_Payable);
			
		
			

		return foreignCompanyRepository.save(ForeignCompanyTax);
	}
	}

