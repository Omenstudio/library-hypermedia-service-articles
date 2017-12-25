package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydra.annotation.context.HydraContextClass;
import com.github.omenstudio.hydra.annotation.context.HydraContextCollection;
import com.github.omenstudio.hydra.annotation.context.HydraContextEntryPoint;
import com.github.omenstudio.hydra.annotation.request.HydraGetRequest;
import com.github.omenstudio.weblibrary.entity.Article;
import com.github.omenstudio.weblibrary.entity.Author;
import com.github.omenstudio.weblibrary.entity.Magazine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/contexts")
public class ContextController {


    @HydraContextEntryPoint
    @HydraGetRequest("EntryPoint")
    public Object getEntryPointContext() {
        return new String[] {"articles", "authors", "magazines"};
    }


    @HydraContextClass
    @HydraGetRequest("Article")
    public Object getArticleContext() {
        return Article.class;
    }


    @HydraContextCollection
    @HydraGetRequest("ArticleCollection")
    public Object getArticleCollection() {
        return Article.class;
    }


    @HydraContextClass
    @HydraGetRequest("Author")
    public Object getAuthorContext() {
        return Author.class;
    }


    @HydraContextCollection
    @HydraGetRequest("AuthorCollection")
    public Object getAuthorCollection() {
        return Author.class;
    }


    @HydraContextClass
    @HydraGetRequest("Magazine")
    public Object getMagazineContext() {
        return Magazine.class;
    }


    @HydraContextCollection
    @HydraGetRequest("MagazineCollection")
    public Object getMagazineCollection() {
        return Magazine.class;
    }
}
