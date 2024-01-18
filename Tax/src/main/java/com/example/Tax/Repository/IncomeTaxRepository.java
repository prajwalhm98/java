package com.example.Tax.Repository;



	import java.math.BigDecimal;

//import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.StreamingHttpOutputMessage.Body;
//import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.stereotype.Repository;

import com.example.Tax.model.IncomeTax;

	@Repository
	public interface IncomeTaxRepository extends JpaRepository<IncomeTax, Long> {
		@Query(value = "SELECT SUM(result) FROM income", nativeQuery = true)
		BigDecimal getTotalExpense();

			}




