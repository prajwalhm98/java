package com.example.CommonDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Commonrepo extends JpaRepository<CommonEntity, Long> {
	

}
