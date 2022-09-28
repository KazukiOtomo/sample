package com.practice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.domain.prepare.Field;
import com.practice.domain.prepare.IPrepareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrepareController {

    final IPrepareService prepareService;

    @Autowired
    public PrepareController(IPrepareService prepareService) {
        this.prepareService = prepareService;
    }

    @GetMapping()
    public Field prepareGame() throws JsonProcessingException {
        var field = prepareService.prepare();
        prepareService.register(field);
        return field;
    }

}
