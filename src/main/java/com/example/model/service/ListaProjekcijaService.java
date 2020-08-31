package com.example.model.service;

import com.example.model.entity.Film;
import com.example.model.entity.ListaProjekcija;

import java.util.Date;
import java.util.List;

public interface ListaProjekcijaService {
    List<ListaProjekcija> findAll();
    List<ListaProjekcija> findAllByFilm(Film film);
    ListaProjekcija findOne(Long id);
    ListaProjekcija findByNazivAndZanr(String naziv, String zanr);
    ListaProjekcija findByNaziv(String naziv);
    List<ListaProjekcija> findAllByFilmId(Long id);
    ListaProjekcija findAllByPocetakAndDan(String pocetak, Date dan);
    ListaProjekcija findByPocetak(String pocetak);
    ListaProjekcija findByDan(Date dan);
    List<ListaProjekcija>findAllByOrderByNaziv();
    List<ListaProjekcija>sortCena();
    void save(ListaProjekcija listaProjekcija);
    void delete(ListaProjekcija listaProjekcija);
    List<ListaProjekcija>pretraga(String pocetak, String cena, String dan, Film film);
}
