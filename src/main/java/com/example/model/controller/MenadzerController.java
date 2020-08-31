package com.example.model.controller;

import com.example.model.service.MenadzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/menadzeri")
public class MenadzerController {
    @Autowired
    private MenadzerService menadzerService;
}
