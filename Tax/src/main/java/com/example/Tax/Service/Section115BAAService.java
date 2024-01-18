package com.example.Tax.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Tax.NotFoundException.ResourceNotFoundException;
import com.example.Tax.Repository.Section115BAARepository;
import com.example.Tax.Repository.Section115BABRepository;
import com.example.Tax.model.Section115BAA;
import com.example.Tax.model.Section115BAB;

@Service
public class Section115BAAService {
	@Autowired
	private Section115BAARepository section115BAARepository;

	public List<Section115BAA> getAllSection115BAA() {
		return section115BAARepository.findAll();
	}

	public Section115BAA getSection115BAAById(Long id) {
		return section115BAARepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
	}

	public Section115BAA createSection115BAA(Section115BAA section115BAA) {
		return section115BAARepository.save(section115BAA);
	}

	public Section115BAA updateSection115BAA(Long id, Section115BAA section115BAADetails) {
		Section115BAA Section115BAA = section115BAARepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		Section115BAA.setCompanyName(section115BAADetails.getCompanyName());
		Section115BAA.setCompanyIncome(section115BAADetails.getCompanyIncome());
		Section115BAA.setDeductions(section115BAADetails.getDeductions());
		return section115BAARepository.save(Section115BAA);
	}

	public void deleteSection115BAA(Long id) {
		Section115BAA Section115BAA = section115BAARepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Income not Found with the id " + id));
		section115BAARepository.delete(Section115BAA);
	}

	private static final double CESS_RATE = 0.04;

	public Section115BAA calculateTax(Section115BAA section115baa) {
        
        String CompanyName = section115baa.getCompanyName();
        
        double CompanyIncome = section115baa.getCompanyIncome();
        double Deduction = section115baa.getDeductions();
       
        
        long tax_Payable = 0;
		long surcharge = 0;
		long Tax=0;

		long income = (long) (CompanyIncome-Deduction);
		section115baa.setIncome(income);
		if (income >= 500000 ) {
		Tax =15;
		tax_Payable = (long) (income * 0.15);
		section115baa.setTax(Tax);
		section115baa.setTax_Payable(tax_Payable);

		if (income > 10000000) {
			 surcharge = (long) (tax_Payable * 0.10);
			 surcharge=10;
			tax_Payable += surcharge;
			section115baa.setSurCharge(surcharge);
			section115baa.setTax_Payable(tax_Payable);
		
		}
		}
	

                // add cess
               long  cess = (long) (tax_Payable * CESS_RATE);
                section115baa.setCess(cess);
                tax_Payable += cess;
                section115baa.setTax_Payable(tax_Payable);
		
	
		

	return section115BAARepository.save(section115baa);
}
}
