package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydra.annotation.request.HydraGetRequest;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mega-api")
public class EntryPointController {

    @HydraGetRequest
    public Object getEntryPoint() {
        JsonObject res = new JsonObject();
        res.addProperty("@context", "/mega-api/context-controller/EntryPoint");
        res.addProperty("@id", "/mega-api/");
        res.addProperty("@type", "EntryPoint");
        res.addProperty("articles_list", "/mega-api/article-controller/list");
        res.addProperty("list_of_authors", "/mega-api/authors-controller/list");
        res.addProperty("magazines_array", "/mega-api/magazines-controller/list");

        return res;
    }
}
