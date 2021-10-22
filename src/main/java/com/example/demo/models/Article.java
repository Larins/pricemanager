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

	@Column(name="name", nullable=false, length=30)
	private String name;
	
	private String postalcode_ini;
	private String postalcode_fin;
	private float price;
	private float qty;
	private LocalDateTime date_ini;
	private LocalDateTime date_fin;
	private int delay_days;
	private float import_bef_promo;
	private long promo_id;
	private String promo_name;
	private float promo_mod;
	private float import_aft_promo;
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
	public float getImport_bef_promo() {
		return import_bef_promo;
	}
	public void setImport_bef_promo(float import_bef_promo) {
		this.import_bef_promo = import_bef_promo;
	}
	public long getPromo_id() {
		return promo_id;
	}
	public void setPromo_id(long promo_id) {
		this.promo_id = promo_id;
	}
	public String getPromo_name() {
		return promo_name;
	}
	public void setPromo_name(String promo_name) {
		this.promo_name = promo_name;
	}
	public float getPromo_mod() {
		return promo_mod;
	}
	public void setPromo_mod(float promo_mod) {
		this.promo_mod = promo_mod;
	}
	public float getImport_aft_promo() {
		return import_aft_promo;
	}
	public void setImport_aft_promo(float import_aft_promo) {
		this.import_aft_promo = import_aft_promo;
	}


	
}
