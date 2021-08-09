package com.teqto.certifyme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teqto.certifyme.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	Optional<List<Article>> findByAuthor(String author);
	Optional<List<Article>> findByVendor(String vendor);
}
