package com.example.Tax.Repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Tax.model.Section115BA;
import com.example.Tax.model.Section115BAB;

public interface Section115BABRepository extends JpaRepository<Section115BAB, Long>{
	

}
