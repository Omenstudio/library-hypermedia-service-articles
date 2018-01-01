package com.github.omenstudio.weblibrary.controller;


import com.github.omenstudio.hydra.annotation.request.HydraDeleteRequest;
import com.github.omenstudio.hydra.annotation.request.HydraGetRequest;
import com.github.omenstudio.hydra.annotation.request.HydraPostRequest;
import com.github.omenstudio.hydra.annotation.request.HydraPutRequest;
import com.github.omenstudio.weblibrary.entity.Author;
import com.github.omenstudio.weblibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mega-api/authors-controller")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @HydraGetRequest("/list")
    public Object getAuthors() {
        return authorRepository.findAll();
    }

    @HydraPostRequest("/list")
    public Object createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @HydraGetRequest("/author-{authorId}")
    public Object getAuthor(@PathVariable Long authorId) {
        return authorRepository.findOne(authorId);
    }

    @HydraPutRequest("/author-{authorId}")
    public Object changeAuthor(@PathVariable Long authorId, @RequestBody Author author) {
        author.setId(authorId);
        return authorRepository.save(author);
    }

    @HydraDeleteRequest("/author-{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorRepository.delete(authorId);
    }
    
}
