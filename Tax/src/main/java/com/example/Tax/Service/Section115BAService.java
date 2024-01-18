package com.example.Tax.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tax.NotFoundException.ResourceNotFoundException;
import com.example.Tax.Repository.IncomeTaxRepository;
import com.example.Tax.Repository.Section115BARepository;
import com.example.Tax.model.IncomeTax;
import com.example.Tax.model.Section115BA;

@Service
public class Section115BAService {

	@Autowired
	private Section115BARepository section115BARepository;

	public List<Section115BA> getAllSection115BA() {
		return section115BARepository.findAll();
	}

	public Section115BA getSection115BAById(Long id) {
		return section115BARepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
	}

	public Section115BA createSection115BA(Section115BA section115BA) {
		return section115BARepository.save(section115BA);
	}

	public Section115BA updateSection115BA(Long id, Section115BA section115BADetails) {
		Section115BA Section115BA = section115BARepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		Section115BA.setCompanyName(section115BADetails.getCompanyName());
		Section115BA.setCompanyIncome(section115BADetails.getCompanyIncome());
		Section115BA.setDeductions(section115BADetails.getDeductions());
		return section115BARepository.save(Section115BA);
	}

	public void deleteSection115BA(Long id) {
		Section115BA income = section115BARepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		section115BARepository.delete(income);
	}

	private static final double CESS_RATE = 0.04;

	public Section115BA calculateTax(Section115BA section115ba) {
        
        String CompanyName = section115ba.getCompanyName();
        
        double CompanyIncome = section115ba.getCompanyIncome();
        double Deduction = section115ba.getDeductions();
       
        
        long tax_Payable = 0;
		long surcharge = 0;
		long Tax=0;

		long income = (long) (CompanyIncome-Deduction);
		section115ba.setIncome(income);
		if (income > 500000 && income <= 5000000) {
			Tax=25;
			tax_Payable= (long) (income * 0.25);
			section115ba.setTax(Tax);
			 section115ba.setTax_Payable(tax_Payable);
		} else if (income>5000001 && income <= 10000000) {
			Tax=30;
			tax_Payable = (long) (1250000 + (income - 5000000) * 0.3);
			section115ba.setTax(Tax);
			section115ba.setTax_Payable(tax_Payable);
		} else if (income>=10000001) {
			Tax=35;
			tax_Payable = (long) (2750000 + (income - 10000000) * 0.35);
			section115ba.setTax(Tax);
			section115ba.setTax_Payable(tax_Payable);
		

		if (income > 10000001) {
			surcharge=12;
			tax_Payable = (long) (tax_Payable * 0.12);
			section115ba.setSurCharge(surcharge);
			section115ba.setTax_Payable(tax_Payable);
		
		}
		}
                // add cess
                long cess = (long) (tax_Payable * CESS_RATE);
                section115ba.setCess(cess);
                tax_Payable += cess;
                section115ba.setTax_Payable(tax_Payable);
		
	
		

	return section115BARepository.save(section115ba);
}

}
