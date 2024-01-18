package com.example.Tax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Section115BAB")
public class Section115BAB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String companyName;
	
	private long companyIncome;
	
	private long deductions;
	private long tax_Payable;
	private long income;
	private long surCharge;
	private long cess;
	private long Tax;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getCompanyIncome() {
		return companyIncome;
	}
	public void setCompanyIncome(long companyIncome) {
		this.companyIncome = companyIncome;
	}
	public long getDeductions() {
		return deductions;
	}
	public void setDeductions(long deductions) {
		this.deductions = deductions;
	}
	public long getTax_Payable() {
		return tax_Payable;
	}
	public void setTax_Payable(long tax_Payable) {
		this.tax_Payable = tax_Payable;
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public long getSurCharge() {
		return surCharge;
	}
	public void setSurCharge(long surCharge) {
		this.surCharge = surCharge;
	}
	public long getCess() {
		return cess;
	}
	public void setCess(long cess) {
		this.cess = cess;
	}
	public long getTax() {
		return Tax;
	}
	public void setTax(long tax) {
		Tax = tax;
	}
	/**
	 * @param id
	 * @param companyName
	 * @param companyIncome
	 * @param deductions
	 * @param tax_Payable
	 * @param income
	 * @param surCharge
	 * @param cess
	 * @param tax
	 */
	public Section115BAB(Long id, String companyName, long companyIncome, long deductions, long tax_Payable,
			long income, long surCharge, long cess, long tax) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.companyIncome = companyIncome;
		this.deductions = deductions;
		this.tax_Payable = tax_Payable;
		this.income = income;
		this.surCharge = surCharge;
		this.cess = cess;
		Tax = tax;
	}

}
