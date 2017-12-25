package com.github.omenstudio.weblibrary.entity;

import com.github.omenstudio.hydra.annotation.JsonExclude;
import com.github.omenstudio.hydra.annotation.model.HydraEntity;
import com.github.omenstudio.hydra.annotation.model.HydraField;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Setter
    private Long id;

    @HydraField(value = "http://schema.org/headline", includeInCollection = true)
    @Column(nullable = false)
    @Getter
    @Setter
    private String title;

    @HydraField("http://schema.org/description")
    @Column
    @Getter
    @Setter
    private String description;

    @HydraField("http://schema.org/bookEdition")
    @Column
    @Getter
    @Setter
    private Integer edition;

    @HydraField("http://schema.org/numberOfPages")
    @Column
    @Getter
    @Setter
    private Integer numberOfPages;

    @HydraField("http://schema.org/isbn")
    @Column
    @Getter
    @Setter
    private String isbn;

    @JsonExclude
    @OneToMany(mappedBy = "magazine", cascade = CascadeType.ALL)
    @Lazy
    @Getter
    @Setter
    private List<Article> articles;


    public Magazine() {}


    public Magazine(String title, String description, Integer edition, Integer numberOfPages, String isbn) {
        this.title = title;
        this.description = description;
        this.edition = edition;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
    }
}