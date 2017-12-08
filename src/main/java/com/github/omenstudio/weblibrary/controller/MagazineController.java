package com.github.omenstudio.weblibrary.controller;

import com.github.omenstudio.hydraback.annotation.request.HydraDeleteRequest;
import com.github.omenstudio.hydraback.annotation.request.HydraGetRequest;
import com.github.omenstudio.hydraback.annotation.request.HydraPostRequest;
import com.github.omenstudio.hydraback.annotation.request.HydraPutRequest;
import com.github.omenstudio.weblibrary.entity.Magazine;
import com.github.omenstudio.weblibrary.repository.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/magazines/")
public class MagazineController {

    @Autowired
    MagazineRepository magazineRepository;

    @HydraGetRequest
    public Object getMagazines() {
        return magazineRepository.findAll();
    }

    @HydraPostRequest
    public Object createMagazine(@RequestBody Magazine magazine) {
        return magazineRepository.save(magazine);
    }

    @HydraGetRequest("/{magazineId}")
    public Object getMagazine(@PathVariable Long magazineId) {
        return magazineRepository.findOne(magazineId);
    }

    @HydraPutRequest("/{magazineId}")
    public Object changeMagazine(@PathVariable Long magazineId, @RequestBody Magazine magazine) {
        magazine.setId(magazineId);
        return magazineRepository.save(magazine);
    }

    @HydraDeleteRequest("/{magazineId}")
    public void deleteMagazine(@PathVariable Long magazineId) {
        magazineRepository.delete(magazineId);
    }

}