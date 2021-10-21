package com.example.demo.models;

import java.sql.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="articles")
public class Article {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	/*@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator( name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "order_id")
	@Type(type="uuid-char")
	@JsonProperty("id")
	private UUID id;*/

	@Column(name="name", nullable=false, length=30)
	private String name;
	
	private String postalcode_ini;
	private String postalcode_fin;
	private float price;
	private float qty;
	private LocalDateTime date_ini;
	private LocalDateTime date_fin;
	private int delay_days;
	private float amount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostalcode_ini() {
		return postalcode_ini;
	}
	public void setPostalcode_ini(String postalcode_ini) {
		this.postalcode_ini = postalcode_ini;
	}
	public String getPostalcode_fin() {
		return postalcode_fin;
	}
	public void setPostalcode_fin(String postalcode_fin) {
		this.postalcode_fin = postalcode_fin;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public LocalDateTime getDate_ini() {
		return date_ini;
	}
	public void setDate_ini(LocalDateTime date_ini) {
		this.date_ini = date_ini;
	}
	public LocalDateTime getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}
	public int getDelay_days() {
		return delay_days;
	}
	public void setDelay_days(int delay_days) {
		this.delay_days = delay_days;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	

	
}
