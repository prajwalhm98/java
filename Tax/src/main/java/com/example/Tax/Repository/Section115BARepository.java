package com.example.Tax.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Tax.model.IncomeTax;
import com.example.Tax.model.Section115BA;

public interface Section115BARepository extends JpaRepository<Section115BA, Long>{
	@Query(value = "SELECT SUM(result) FROM income", nativeQuery = true)
	BigDecimal getTotalExpense();

	}
