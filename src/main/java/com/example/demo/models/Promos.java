package com.example.demo.models;

import java.time.LocalDateTime;

public enum Promos {
	
	SINPROMO("SINPROMO", 1, null, null), NAVIDAD2021("NAVIDAD2020", 1.5, "2020-12-20 00:00:00", "2021-01-08 00:00:00");
	
	private String promo;
	private double modifyer;
	private LocalDateTime promo_dateini;
	private LocalDateTime promo_datefin;
	
	
	Promos(String promo, double modifyer, String promo_dateini, String promo_datefin) {
		this.promo = promo;
		this.modifyer = modifyer;
		this.promo_dateini = LocalDateTime.parse(promo_dateini);
		this.promo_datefin = LocalDateTime.parse(promo_datefin);
	}
	

	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public double getModifyer() {
		return modifyer;
	}
	public void setModifyer(double modifyer) {
		this.modifyer = modifyer;
	}
	public LocalDateTime getPromo_dateini() {
		return promo_dateini;
	}
	public void setPromo_dateini(LocalDateTime promo_dateini) {
		this.promo_dateini = promo_dateini;
	}
	public LocalDateTime getPromo_datefin() {
		return promo_datefin;
	}
	public void setPromo_datefin(LocalDateTime promo_datefin) {
		this.promo_datefin = promo_datefin;
	}
	
	

	
	
	
	

}
