package com.github.omenstudio.weblibrary.entity;

import com.github.omenstudio.hydraback.annotation.HydraEntity;
import com.github.omenstudio.hydraback.annotation.HydraField;
import com.github.omenstudio.hydraback.annotation.JsonExclude;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.List;

@HydraEntity("http://schema.org/Book")
@Entity
@Table(name = "books")
public class Magazine {

    @JsonExclude
    @Id
    @GeneratedValue
    private Long id;

    @HydraField("http://schema.org/headline")
    @Column(nullable = false)
    private String title;

    @HydraField("http://schema.org/description")
    @Column
    private String description;

    @HydraField("http://schema.org/bookEdition")
    @Column
    private Integer edition;

    @HydraField("http://schema.org/numberOfPages")
    @Column
    private Integer numberOfPages;

    @HydraField("http://schema.org/isbn")
    @Column
    private String isbn;

    @JsonExclude
    @OneToMany(mappedBy = "magazine", cascade = CascadeType.ALL)
    @Lazy
    private List<Article> articles;


    public Magazine() { }

    public Magazine(String title, String description, Integer edition, Integer numberOfPages, String isbn) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}