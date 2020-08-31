package com.example.model.service;

import com.example.model.entity.Film;
import com.example.model.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService{

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public List<Film> findAll() {
        List<Film> filmovi = this.filmRepository.findAll();
        return filmovi;
    }

    @Override
    public Film findOne(Long id) {
        Film film = this.filmRepository.getOne(id);
        return film;
    }

    @Override
    public Film findByNaziv(String naziv){
        Film film = this.filmRepository.findByNaziv(naziv);
        return film;
    }

    @Override
    public Film findAllByNazivAndZanr(String naziv, String zanr){
        Film film = this.filmRepository.findAllByNazivAndZanr(naziv,zanr);
        return film;
    }

    @Override
    public Film findAllByNazivAndOcena(String naziv, Double ocena){
        Film film = this.filmRepository.findAllByNazivAndOcena(naziv,ocena);
        return film;
    }

    @Override
    public Film findAllByNazivAndOcenaAndZanr(String naziv, Double ocena, String zanr){
        Film film = this.filmRepository.findAllByNazivAndOcenaAndZanr(naziv,ocena,zanr);
        return film;
    }


    @Override
    public List<Film> findAllByZanr(String zanr){
        List<Film>film = this.filmRepository.findAllByZanr(zanr);
        return film;
    }

    @Override
    public List<Film> findAllByOcena(Double ocena){
        List<Film>film = this.filmRepository.findAllByOcena(ocena);
        return film;
    }

    //sortiranje po oceni
    @Override
    public List<Film>sortOcena(){
        return filmRepository.findAllByOrderByOcenaAsc();
    }

    //sort po zanru
    @Override
    public List<Film>sortZanr(){
        return filmRepository.findAllByOrderByZanr();
    }

    //sort po nazivu
    @Override
    public List<Film>sortNaziv(){
        return filmRepository.findAllByOrderByNaziv();
    }




}
