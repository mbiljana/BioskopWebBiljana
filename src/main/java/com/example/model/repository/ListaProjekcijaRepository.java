package com.example.model.repository;
import com.example.model.entity.Film;
import com.example.model.entity.ListaProjekcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ListaProjekcijaRepository extends JpaRepository<ListaProjekcija,Long> {
    List<ListaProjekcija>findAllByFilm(Film film);
    ListaProjekcija findByNazivAndZanr(String naziv, String zanr);
    ListaProjekcija findByNaziv(String naziv);
    List<ListaProjekcija> findAllByFilmId(Long id);
    ListaProjekcija findAllByPocetakAndDan(String pocetak, Date dan);
    ListaProjekcija findByPocetak(String pocetak);
    ListaProjekcija findByDan(Date dan);
    List<ListaProjekcija>findAllByOrderByNaziv();
    List<ListaProjekcija>findAllByOrderByCenaAsc();
    List<ListaProjekcija>findAllByPocetakOrNazivOrCenaOrZanr(String pocetak, String naziv, String cena, String zanr);
    List<ListaProjekcija>findAllByPocetakOrCenaOrDanOrFilm(String pocetak, String cena, String danProjekcije, Film film);




}
