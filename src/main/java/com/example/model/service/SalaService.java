package com.example.model.service;

import com.example.model.entity.dto.DTO.SalaDTO;
import com.example.model.entity.Sala;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface SalaService {
    List<Sala> findAll();
    void delete(Sala sala);
    Sala findById(Long id);
    Sala save(Sala sala);
    Sala findByNaziv(String naziv);
    Sala findOne(Long id);

}

