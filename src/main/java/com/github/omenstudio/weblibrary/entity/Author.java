package com.github.omenstudio.weblibrary.entity;

import com.github.omenstudio.hydra.annotation.HydraEntity;
import com.github.omenstudio.hydra.annotation.HydraField;
import com.github.omenstudio.hydra.annotation.JsonExclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@HydraEntity("http://schema.org/Person")
@Entity
@Table(name = "authors")
public class Author {

    @JsonExclude
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @HydraField("http://schema.org/name")
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
