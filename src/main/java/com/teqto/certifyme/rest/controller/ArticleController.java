package com.teqto.certifyme.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.certifyme.entity.Article;
import com.teqto.certifyme.repository.ArticleRepository;
import com.teqto.certifyme.utils.ObjectUtility;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

	@Autowired
	private ArticleRepository repository;
	
	@PostMapping()
	ResponseEntity<?> create(@RequestBody Article article) throws URISyntaxException {
			article = (Article)ObjectUtility.setDateUpdate(article);
			Article e = repository.save(article);
			return ResponseEntity.created(new URI("/api/article/create/" + article.getId())).body(e);
	}
	
	@GetMapping("/public/articleid/{articleid}")
	ResponseEntity<?> find(@PathVariable Long articleid) {
		Optional<Article> article = repository.findById(articleid);
		return article.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/author/{author}")
	ResponseEntity<?> findEmail(@PathVariable String author) {
		Optional<List<Article>> article = repository.findByAuthor(author);
		return article.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/vendor/{vendor}")
	ResponseEntity<?> findByVendor(@PathVariable String vendor) {
		Optional<List<Article>> article = repository.findByVendor(vendor);
		return article.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping()
	ResponseEntity<?> update(@RequestBody Article article) {
		article = (Article)ObjectUtility.setDateUpdate(article);
		article = repository.save(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
}
