package com.example.model.repository;

import com.example.model.entity.EnumUloga;
import com.example.model.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByKorisnickoIme(String korisnicko_ime);
    Korisnik findByKorisnickoImeAndLozinka(String korisnicko_ime, String lozinka);
    Korisnik findByKorisnickoImeAndLozinkaAndAktivan(String korisnicko_ime, String lozinka, boolean aktivan);
    List<Korisnik>findAllByUloga(EnumUloga uloga);




}
