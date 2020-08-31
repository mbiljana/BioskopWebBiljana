package com.example.model.service;

import com.example.model.entity.Menadzer;
import com.example.model.repository.MenadzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenadzerServiceImpl implements MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;

    @Override
    public Menadzer findOne(Long id) {
        return menadzerRepository.getOne(id);
    }


}
