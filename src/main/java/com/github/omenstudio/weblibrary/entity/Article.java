package com.github.omenstudio.weblibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.omenstudio.hydraback.annotation.HydraEntity;
import com.github.omenstudio.hydraback.annotation.HydraField;
import com.github.omenstudio.hydraback.annotation.HydraLink;
import com.github.omenstudio.hydraback.annotation.JsonExclude;
import com.github.omenstudio.weblibrary.utils.ArticleJsonDeserializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@HydraEntity("http://schema.org/Article")
@Entity
@JsonDeserialize(using = ArticleJsonDeserializer.class)
@Table
public class Article {

    @JsonExclude
    @Id
    @GeneratedValue
    private Long id;

    @HydraField("http://schema.org/headline")
    @Column(nullable = false)
    private String title;

    @HydraField("http://schema.org/description")
    @Column
    private String annotation;

    @HydraField("http://schema.org/pageStart")
    @Column
    private String pageStart;

    @HydraField("http://schema.org/pageEnd")
    @Column
    private String pageEnd;

    @HydraField("http://schema.org/wordCount")
    @Column
    private Integer wordCount;


    @HydraLink("http://schema.org/Person")
    @JsonIgnore
    @ManyToMany
    private List<Author> authors;

    @HydraLink("http://schema.org/Book")
    @JsonIgnore
    @ManyToOne
    private Magazine magazine;


    public Article() {}


    public Article(String title, String annotation, String pageStart, String pageEnd, Integer wordCount) {
        this.title = title;
        this.annotation = annotation;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
        this.wordCount = wordCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getPageStart() {
        return pageStart;
    }

    public void setPageStart(String pageStart) {
        this.pageStart = pageStart;
    }

    public String getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(String pageEnd) {
        this.pageEnd = pageEnd;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        this.authors.add(author);
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
}
