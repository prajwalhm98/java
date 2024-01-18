package com.example.Tax.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tax.NotFoundException.ResourceNotFoundException;
import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.Repository.Section115BARepository;
import com.example.Tax.model.Section115BA;
import com.example.Tax.model.Section115BAB;

@Service
public class Section115BABService {

	@Autowired
	private Section115BABRepository section115BABRepository;

	public List<Section115BAB> getAllSection115BAB() {
		return section115BABRepository.findAll();
	}

	public Section115BAB getSection115BABById(Long id) {
		return section115BABRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
	}

	public Section115BAB createSection115BAB(Section115BAB section115BAB) {
		return section115BABRepository.save(section115BAB);
	}

	public Section115BAB updateSection115BAB(Long id, Section115BAB section115BABDetails) {
		Section115BAB Section115BAB = section115BABRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		Section115BAB.setCompanyName(section115BABDetails.getCompanyName());
		Section115BAB.setCompanyIncome(section115BABDetails.getCompanyIncome());
		Section115BAB.setDeductions(section115BABDetails.getDeductions());
		return section115BABRepository.save(Section115BAB);
	}

	public void deleteSection115BAB(Long id) {
		Section115BAB Section115BAB = section115BABRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		section115BABRepository.delete(Section115BAB);
	}

	private static final double CESS_RATE = 0.04;

	public Section115BAB calculateTax(Section115BAB section115bab) {
        
        String CompanyName = section115bab.getCompanyName();
        
        double CompanyIncome = section115bab.getCompanyIncome();
        double Deduction = section115bab.getDeductions();
       
        
        long tax_Payable = 0;
		long surcharge = 0;
		long Tax=0;

		long income = (long) (CompanyIncome-Deduction);
		section115bab.setIncome(income);
		if (income >= 500000) {
		Tax =15;
		tax_Payable = (long) (income * 0.15);
		section115bab.setTax(Tax);
		section115bab.setTax_Payable(tax_Payable);

		if (income > 10000000) {
			 surcharge = (long) (tax_Payable * 0.10);
			 surcharge=10;
			tax_Payable += surcharge;
			section115bab.setSurCharge(surcharge);
			section115bab.setTax_Payable(tax_Payable);
		
		}
		}
	

                // add cess
               long  cess = (long) (tax_Payable * CESS_RATE);
                section115bab.setCess(cess);
                tax_Payable += cess;
                section115bab.setTax_Payable(tax_Payable);
		
	
		

	return section115BABRepository.save(section115bab);
}
}
