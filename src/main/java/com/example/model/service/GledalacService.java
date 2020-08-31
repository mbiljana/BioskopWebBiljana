package com.example.model.service;

import com.example.model.entity.Gledalac;

import java.util.List;

public interface GledalacService {
    void dodajGledaoca(Gledalac gledalac);
    Gledalac findByKorisnicko_ime(String korisnickoIme);
    Gledalac findByImeAndPrezime(String ime, String prezime);
    List<Gledalac> findAll();

}
