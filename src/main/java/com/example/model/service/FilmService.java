package com.example.model.service;

import com.example.model.entity.Film;

import java.util.List;

public interface FilmService {
    List<Film> findAll();
    Film findOne(Long id);
    Film findByNaziv(String naziv);
    Film findAllByNazivAndZanr(String naziv, String zanr);
    Film findAllByNazivAndOcena(String naziv, Double ocena);
    Film findAllByNazivAndOcenaAndZanr(String naziv, Double ocena, String zanr);
    List<Film> findAllByZanr(String zanr);
    List<Film> findAllByOcena(Double ocena);
    List<Film>sortOcena();
    List<Film>sortZanr();
    List<Film>sortNaziv();

}
