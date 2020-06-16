package com.example.model.service;

import com.example.model.DTO.KorisnikDTO;

public interface KorisnikService {
    KorisnikDTO dodajKorisnika(KorisnikDTO dto);
    KorisnikDTO prijavaKorisnika(String korisnickoIme,String lozinka, boolean aktivan);
    KorisnikDTO pregledProfila(String korisnickoIme);


}
