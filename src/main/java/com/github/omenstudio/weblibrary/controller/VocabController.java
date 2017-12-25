package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydra.annotation.request.HydraGetRequest;
import com.github.omenstudio.hydra.builder.VocabBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/vocab")
public class VocabController {

    @Autowired
    VocabBuilder vocabBuilder;

    @HydraGetRequest
    public Object getApiDocumentation() {
        return vocabBuilder.buildVocabulary();
    }

}
