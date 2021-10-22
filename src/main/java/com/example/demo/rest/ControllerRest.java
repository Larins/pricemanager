package com.example.demo.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ArticlesDAO;
import com.example.demo.dao.PricingDAO;
import com.example.demo.models.Article;
import com.example.demo.models.Pricing;
import com.example.demo.repository.IPricingRepository;

@RestController //Esta clase va a ser un servicio REST
@RequestMapping("") //En esta URL se van a exponer los servicios de esta clase. En este caso la dejamos en blanco.
public class ControllerRest {
	
	@Autowired //Inyección de dependencias
	private ArticlesDAO articlesDAO;
	private PricingDAO pricingDAO;
	
	@Autowired
	IPricingRepository repositoryPricing;
	

	//METODOS CRUD PARA LAS EXPEDICIONES (ARTICLES)
	
	@GetMapping("articles") //articles GET todos
	//URL: http://localhost:8080/articles/
	public ResponseEntity<List<Article>> getArticles() {
		List<Article> articles = articlesDAO.findAll();
		return ResponseEntity.ok(articles);
	}
	
	@GetMapping("pricing") //articles GET todos
	//URL: http://localhost:8080/pricing/
	public ResponseEntity<List<Pricing>> getPricing() {
		List<Pricing> pricing = pricingDAO.findAll();
		return ResponseEntity.ok(pricing);
	}
	
	@RequestMapping(value="articles/{articleId}")  //articles GET por ID
	//URL: http://localhost:8080/articles/1
	public ResponseEntity<Article> getArticleById(@PathVariable("articleId") Long articleId) {
		Optional<Article> optionalArticle = articlesDAO.findById(articleId);
		if (optionalArticle.isPresent()) {
			return ResponseEntity.ok(optionalArticle.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	

	
	@PostMapping("articles") //articles POST (insertar nuevo article)
	public ResponseEntity<Article> crearArticle(@RequestBody Article article/*, Pricing pricing*/) {
		Article newArticle = articlesDAO.save(article);
		newArticle.setName(article.getName());
		newArticle.setPostalcode_ini(article.getPostalcode_ini());
		newArticle.setPostalcode_fin(article.getPostalcode_fin());
		newArticle.setPrice(article.getPrice());
		newArticle.setQty(article.getQty());
		newArticle.setDate_ini(article.getDate_ini());
		newArticle.setDelay_days(article.getDelay_days());
		newArticle.setDate_fin(article.getDate_ini().plusDays(article.getDelay_days()));
		newArticle.setImport_bef_promo(article.getPrice()*article.getQty());
		newArticle.setPromo_id(pricingDAO.findPricingById(article.getPromo_id()));
			newArticle.setPromo_name(repositoryPricing.findNamebyId(article.getPromo_id()));
		newArticle.setPromo_mod(article.getPromo_mod());
		newArticle.setImport_aft_promo(article.getImport_bef_promo()*article.getPromo_mod());
		articlesDAO.save(newArticle);
		return ResponseEntity.ok(newArticle);
	}
	
	
	/*@PostMapping("articles") //articles POST (insertar nuevo article)
	public ResponseEntity<Article> crearArticle(@RequestBody Article article) {
		Article newArticle = articlesDAO.save(article);
		newArticle.setName(article.getName());
		newArticle.setPostalcode_ini(article.getPostalcode_ini());
		newArticle.setPostalcode_fin(article.getPostalcode_fin());
		newArticle.setPrice(article.getPrice());
		newArticle.setQty(article.getQty());
		newArticle.setDate_ini(article.getDate_ini());
		newArticle.setDelay_days(article.getDelay_days());
		newArticle.setDate_fin(article.getDate_ini().plusDays(article.getDelay_days()));
		newArticle.setImport_bef_promo(article.getPrice()*article.getQty());
		newArticle.setPromo_id(article.getPromo_id());
		newArticle.setPromo_name(article.getPromo_name());
		newArticle.setPromo_mod(article.getPromo_mod());
		newArticle.setImport_aft_promo(article.getImport_bef_promo()*article.getPromo_mod());
		articlesDAO.save(newArticle);
		return ResponseEntity.ok(newArticle);
	}*/
	
	@PutMapping("articles") //articles PUT (modificar article existente)
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		Optional <Article> optionalArticle = articlesDAO.findById(article.getId());
		if (optionalArticle.isPresent()) {
			Article updateArticle = optionalArticle.get();
			updateArticle.setPrice(article.getPrice());
			updateArticle.setImport_bef_promo(article.getPrice()*article.getQty());
			updateArticle.setImport_aft_promo(article.getPrice()*article.getQty()*article.getPromo_mod());
			updateArticle.setDate_fin(article.getDate_ini().plusDays(article.getDelay_days()));
			articlesDAO.save(updateArticle);
			return ResponseEntity.ok(updateArticle);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(value="articles/{articleId}") //articles DELETE (eliminar article existente)
	public ResponseEntity<Void> deleteArticles(@PathVariable("articleId") Long articleId) {
		articlesDAO.deleteById(articleId);
		return ResponseEntity.ok(null);
	}
	
	
	
	
}

