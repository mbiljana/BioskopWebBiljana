package com.example.model.repository;
import com.example.model.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByNaziv(String naziv);
    Film findAllByNazivAndZanr(String naziv, String zanr);
    Film findAllByNazivAndOcena(String naziv, Double ocena);
    Film findAllByNazivAndOcenaAndZanr(String naziv, Double ocena, String zanr);
    List<Film> findAllByOcena(Double ocena);
    List<Film> findAllByZanr(String zanr);
    List<Film>findAllByOrderByOcenaAsc();
    List<Film> findAllByOrderByNaziv();
    List<Film> findAllByOrderByZanr();


}
