package com.example.model.service;

import com.example.model.DTO.SalaDTO;
import com.example.model.entity.Sala;

import java.util.ArrayList;
import java.util.HashSet;

public interface SalaService {
    HashSet<Sala> dodajSalu(ArrayList<SalaDTO> salaDTOS);
}

