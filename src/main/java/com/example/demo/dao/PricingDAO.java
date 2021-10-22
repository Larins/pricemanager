package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Pricing;


public interface PricingDAO extends JpaRepository<Pricing,Long> {
	
	Pricing findById(long id);

	long findPricingById(long promo_id);


}
