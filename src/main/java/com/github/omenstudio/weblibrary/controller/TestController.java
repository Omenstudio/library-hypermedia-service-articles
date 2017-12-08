package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.weblibrary.repository.ArticleRepository;
import com.github.omenstudio.weblibrary.repository.AuthorRepository;
import com.github.omenstudio.weblibrary.repository.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    MagazineRepository magazineRepository;

    @Autowired
    AuthorRepository authorRepository;


    @GetMapping("/iamalive")
    public boolean iAmAlive() {
        return true;
    }


    @GetMapping("/resetdb")
    public void resetDb() {
        // Clear the database
        articleRepository.deleteAll();
        magazineRepository.deleteAll();
        authorRepository.deleteAll();


    }


}
