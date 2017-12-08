package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydraback.annotation.request.HydraGetRequest;
import com.github.omenstudio.hydraback.builder.ContextBuilder;
import com.github.omenstudio.weblibrary.entity.Article;
import com.github.omenstudio.weblibrary.entity.Author;
import com.github.omenstudio.weblibrary.entity.Magazine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/contexts")
public class ContextController {


    @HydraGetRequest("EntryPoint")
    public Object getEntryPointContext() {
        return ContextBuilder.buildForEntryPoint("articles", "authors", "magazines");
    }

    @HydraGetRequest("Article")
    public Object getArticleContext() {
        return ContextBuilder.buildForClass(Article.class);
    }

    @HydraGetRequest("ArticleCollection")
    public Object getArticleCollection() {
        return ContextBuilder.buildForCollection(Article.class);
    }

    @HydraGetRequest("Author")
    public Object getAuthorContext() {
        return ContextBuilder.buildForClass(Author.class);
    }

    @HydraGetRequest("AuthorCollection")
    public Object getAuthorCollection() {
        return ContextBuilder.buildForCollection(Author.class);
    }

    @HydraGetRequest("Magazine")
    public Object getMagazineContext() {
        return ContextBuilder.buildForClass(Magazine.class);
    }

    @HydraGetRequest("MagazineCollection")
    public Object getMagazineCollection() {
        return ContextBuilder.buildForCollection(Magazine.class);
    }
}
