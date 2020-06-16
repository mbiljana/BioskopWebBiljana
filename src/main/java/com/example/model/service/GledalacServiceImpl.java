package com.example.model.service;

import com.example.model.repository.GledalacRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GledalacServiceImpl implements GledalacService{
    @Autowired
    private GledalacRepository gledalacRepository;

}
