package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Article;

public interface ArticlesDAO extends JpaRepository<Article,Long> {


}
