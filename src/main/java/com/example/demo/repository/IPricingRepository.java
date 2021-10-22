package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Pricing;

@Repository
public interface IPricingRepository extends JpaRepository<Pricing, Long> {
	
	 @Query(value = "select name from pricing " 
	          +"where (id = :id) "
			  + "limit 1", nativeQuery = true)
	 String findNamebyId(@Param("id")Long id);


}
