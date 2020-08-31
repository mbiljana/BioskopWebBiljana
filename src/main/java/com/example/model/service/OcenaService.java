package com.example.model.service;

import com.example.model.entity.Ocena;

import java.util.List;

public interface OcenaService {
    Ocena create(Ocena ocena);
    List<Ocena> findAll();
    List<Ocena>getbyID(Long id);
    List<Ocena>getByFilmID(Long id);
}
