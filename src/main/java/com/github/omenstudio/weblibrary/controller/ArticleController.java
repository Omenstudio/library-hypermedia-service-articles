package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydra.annotation.request.HydraDeleteRequest;
import com.github.omenstudio.hydra.annotation.request.HydraGetRequest;
import com.github.omenstudio.hydra.annotation.request.HydraPostRequest;
import com.github.omenstudio.hydra.annotation.request.HydraPutRequest;
import com.github.omenstudio.weblibrary.entity.Article;
import com.github.omenstudio.weblibrary.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mega-api/article-controller")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @HydraGetRequest("/list")
    public Object getArticles() {
        return articleRepository.findAll();
    }

    @HydraPostRequest("/list")
    public Object createArticle(@RequestBody Article article,
                             @RequestParam(required = false) String author,
                             @RequestParam(required = false) String publisher) {
        return articleRepository.save(article);
    }

    @HydraGetRequest("/article-{articleId}")
    public Object getArticle(@PathVariable Long articleId) {
        return articleRepository.findOne(articleId);
    }

    @HydraPutRequest("/article-{articleId}")
    public Object changeArticle(@PathVariable Long articleId, @RequestBody Article article) {
        article.setId(articleId);
        return articleRepository.save(article);
    }

    @HydraDeleteRequest("/article-{articleId}")
    public void deleteArticle(@PathVariable Long articleId) {
        articleRepository.delete(articleId);
    }

}
