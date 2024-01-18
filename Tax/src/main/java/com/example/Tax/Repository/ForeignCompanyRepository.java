package com.example.Tax.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Tax.model.ForeignCompanyTax;


public interface ForeignCompanyRepository extends JpaRepository<ForeignCompanyTax, Long>{

}
