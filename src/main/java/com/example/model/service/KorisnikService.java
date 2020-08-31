package com.example.model.service;


import com.example.model.entity.EnumUloga;
import com.example.model.entity.Korisnik;
import com.example.model.entity.dto.DTO.PrijavaKorisnikaDTO;

import java.util.List;

public interface KorisnikService {

    Korisnik findByKorisnickoIme(String ime);
    List<Korisnik> findAll();
    Korisnik save(Korisnik korisnik);
    void delete(Long id);
    List<Korisnik> findAllMenadzeri(EnumUloga uloga);
    Korisnik findOne(Long id);
    Korisnik loginProvera(PrijavaKorisnikaDTO korisnik);



}
