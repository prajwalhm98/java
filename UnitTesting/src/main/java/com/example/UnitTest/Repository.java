package com.example.UnitTest;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<EmployeeModel, Long>{

	 EmployeeModel save(EmployeeModel employee);
	 
}
