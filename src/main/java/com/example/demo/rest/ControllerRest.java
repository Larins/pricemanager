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
import com.example.demo.models.Article;
import com.example.demo.models.Billing;
import com.example.demo.models.Article;


@RestController //Esta clase va a ser un servicio REST
@RequestMapping("") //En esta URL se van a exponer los servicios de esta clase. En este caso la dejamos en blanco.
public class ControllerRest {
	
	@Autowired //Inyección de dependencias
	private ArticlesDAO articlesDAO;
	

	//METODOS CRUD PARA LAS EXPEDICIONES (ARTICLES)
	
	@GetMapping("articles") //articles GET todos
	//URL: http://localhost:8080/articles/
	public ResponseEntity<List<Article>> getArticles() {
		List<Article> articles = articlesDAO.findAll();
		return ResponseEntity.ok(articles);
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
	public ResponseEntity<Article> crearArticle(@RequestBody Article article) {
		Article newArticle = articlesDAO.save(article);
		newArticle.setPrice(article.getPrice());
		newArticle.setAmount(article.getPrice()*article.getQty());
		newArticle.setDate_fin(article.getDate_ini().plusDays(article.getDelay_days()));
		articlesDAO.save(newArticle);
		return ResponseEntity.ok(newArticle);
	}
	
	@PutMapping("articles") //articles PUT (modificar article existente)
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		Optional <Article> optionalArticle = articlesDAO.findById(article.getId());
		if (optionalArticle.isPresent()) {
			Article updateArticle = optionalArticle.get();
			updateArticle.setName(article.getName());
			updateArticle.setPostalcode_ini(article.getPostalcode_ini());
			updateArticle.setPostalcode_fin(article.getPostalcode_fin());
			updateArticle.setPrice(article.getPrice());
			updateArticle.setQty(article.getQty());
			updateArticle.setDate_ini(article.getDate_ini());
			//updateArticle.setDate_fin(article.getDate_ini().plusDays(article.getDelay_days()));
			//updateArticle.setDate_fin(LocalDateTime.now());
			updateArticle.setDate_fin(article.getDate_ini());
			updateArticle.setAmount(article.getPrice()*article.getQty());
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

