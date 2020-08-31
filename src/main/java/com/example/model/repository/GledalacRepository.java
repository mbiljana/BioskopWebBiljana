package com.example.model.repository;
import com.example.model.entity.Gledalac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GledalacRepository extends JpaRepository<Gledalac,Long> {
    Gledalac findByKorisnickoIme(String korisnickoIme);
    Gledalac findByImeAndPrezime(String ime, String prezime);
}
