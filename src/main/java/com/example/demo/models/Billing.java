package com.example.demo.models;

import java.sql.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="billing")
public class Billing {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//@Column(name="name", nullable=false, length=30)
	//private String name;
	
	private float price_ini;
	private boolean promo;
	private float promo_amount;
	private float price_final;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Article article_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrice_ini() {
		return price_ini;
	}

	public void setPrice_ini(float price_ini) {
		this.price_ini = price_ini;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(boolean promo) {
		this.promo = promo;
	}

	public float getPromo_amount() {
		return promo_amount;
	}

	public void setPromo_amount(float promo_amount) {
		this.promo_amount = promo_amount;
	}

	public float getPrice_final() {
		return price_final;
	}

	public void setPrice_final(float price_final) {
		this.price_final = price_final;
	}

	public Article getArticle_id() {
		return article_id;
	}

	public void setArticle_id(Article article_id) {
		this.article_id = article_id;
	}
	

	
	
	
	

	
}
