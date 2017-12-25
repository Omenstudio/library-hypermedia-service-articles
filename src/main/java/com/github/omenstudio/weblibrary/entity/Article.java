package com.github.omenstudio.weblibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.omenstudio.hydra.annotation.JsonExclude;
import com.github.omenstudio.hydra.annotation.model.HydraEntity;
import com.github.omenstudio.hydra.annotation.model.HydraField;
import com.github.omenstudio.hydra.annotation.model.HydraLink;
import com.github.omenstudio.weblibrary.utils.ArticleJsonDeserializer;
import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    private Long id;

    @HydraField(value = "http://schema.org/headline", includeInCollection = true)
    @Column(nullable = false)
    @Getter
    @Setter
    private String title;

    @HydraField("http://schema.org/description")
    @Column(columnDefinition = "TEXT")
    @Getter
    @Setter
    private String annotation;

    @HydraField("http://schema.org/pageStart")
    @Column
    @Getter
    @Setter
    private String pageStart;

    @HydraField("http://schema.org/pageEnd")
    @Column
    @Getter
    @Setter
    private String pageEnd;

    @HydraField("http://schema.org/wordCount")
    @Column
    @Getter
    @Setter
    private Integer wordCount;

    @HydraLink(value = "http://schema.org/Person", includeInCollection = true)
    @JsonIgnore
    @ManyToMany
    @Getter
    @Setter
    private List<Author> authors;

    @HydraLink("http://schema.org/Book")
    @JsonIgnore
    @ManyToOne
    @Getter
    @Setter
    private Magazine magazine;


    public Article() {
    }

    public Article(String title, String annotation, String pageStart, String pageEnd, Integer wordCount) {
        this.title = title;
        this.annotation = annotation;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
        this.wordCount = wordCount;
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        this.authors.add(author);
    }

}
