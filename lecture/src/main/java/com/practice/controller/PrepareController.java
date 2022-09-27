package com.practice.controller;

import com.practice.domain.prepare.Field;
import com.practice.domain.prepare.IPrepareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PrepareController {

    final IPrepareService prepareService;

    @Autowired
    public PrepareController(IPrepareService prepareService) {
        this.prepareService = prepareService;
    }

    @GetMapping()
    public Field prepareGame() {
        return new Field();
    }

}
