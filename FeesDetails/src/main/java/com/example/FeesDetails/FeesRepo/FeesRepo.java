package com.example.FeesDetails.FeesRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FeesDetails.Entity.Fees;


import feign.Param;

@Repository
public interface FeesRepo extends JpaRepository<Fees, Long> {

//	FeesEntity findByStudentId(Long studentId);
	
	 @Query(
		        nativeQuery = true,
		        
		      value  = "SELECT ea.id,ea.amount_paid, ea.amount_pending FROM school.feesdetails ea join school.student e on e.id = ea.student_Id where ea.student_Id=:studentId")
		       Optional<Fees> findFeesByStudentId(@Param("studentId") Long studentId);

	//Optional<Fees> findFeesByStudentId(int studentId);

	//Optional<Fees> findFeesEntityByStudentId(int studentId);

	
		}


