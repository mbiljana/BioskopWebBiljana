package com.example.model.repository;
import com.example.model.entity.Menadzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MenadzerRepository extends JpaRepository<Menadzer,Long> {
    Menadzer findByKorisnickoIme(String korisnicko_ime);
    Menadzer findByImeAndPrezime(String ime, String prezime);
}
