package com.example.model.controller;

import com.example.model.service.GledalacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/gledaoci")
public class GledalacController {
    @Autowired
    private GledalacService gledalacService;
}
