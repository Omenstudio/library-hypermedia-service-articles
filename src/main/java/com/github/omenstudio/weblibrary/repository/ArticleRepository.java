package com.github.omenstudio.weblibrary.repository;

import com.github.omenstudio.weblibrary.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}