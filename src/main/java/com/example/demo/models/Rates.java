package com.example.demo.models;

public enum Rates {
	
	NORMAL("NORMAL",10, 100), RAPIDO("RAPIDO",5,200), EXPRES("EXPRES",1,500);
	
	private String tarifa;
	private int delay_days;
	private float price;
	
	private Rates(String trairfa, int delay_days, float price) {
		this.tarifa = tarifa;
		this.delay_days = delay_days;
		this.price = price;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public int getDelay_days() {
		return delay_days;
	}

	public void setDelay_days(int delay_days) {
		this.delay_days = delay_days;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
