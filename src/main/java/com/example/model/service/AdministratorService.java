package com.example.model.service;

import com.example.model.entity.Administrator;
import com.example.model.repository.AdministratorRepository;

import java.util.List;

public interface AdministratorService {
    List<Administrator> findAll();
    Administrator findOne(long id);



}
