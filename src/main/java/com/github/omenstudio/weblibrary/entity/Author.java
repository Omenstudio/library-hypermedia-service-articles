package com.github.omenstudio.weblibrary.entity;

import com.github.omenstudio.hydra.annotation.JsonExclude;
import com.github.omenstudio.hydra.annotation.model.HydraEntity;
import com.github.omenstudio.hydra.annotation.model.HydraField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@HydraEntity(
        value = "http://schema.org/Person",
        pathToEntity = "/authors-controller/author-",
        pathToCollection = "/authors-controller/list"
)
@Entity
@Table(name = "authors")
public class Author {

    @JsonExclude
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @HydraField(value = "http://schema.org/name", includeInCollection = true)
    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @HydraField("http://schema.org/birthDate")
    @Column
    @Getter
    @Setter
    private Date birthDate;

    @JsonExclude
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    @Lazy
    @Getter
    @Setter
    private List<Article> articles;

    public Author() {
    }

    public Author(String name, Date birthDate) {
        this.name = name;
        if (birthDate != null) this.birthDate = birthDate;
    }

}
