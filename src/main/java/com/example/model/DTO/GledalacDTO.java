package com.example.model.DTO;

import com.example.model.entity.Film;
import com.example.model.entity.Ocena;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GledalacDTO implements Serializable {

    private Set<Film> odgledaniFilmovi = new HashSet<>();

    private Set<Film> rezervisaniFilmovi = new HashSet<>();

    private Set<Ocena> ocenjeniFilmovi = new HashSet<>();

    public GledalacDTO(Set<Film> odgledaniFilmovi, Set<Film> rezervisaniFilmovi, Set<Ocena> ocenjeniFilmovi) {
        this.odgledaniFilmovi = odgledaniFilmovi;
        this.rezervisaniFilmovi = rezervisaniFilmovi;
        this.ocenjeniFilmovi = ocenjeniFilmovi;
    }

    public GledalacDTO() {
    }

    public Set<Film> getOdgledaniFilmovi() {
        return odgledaniFilmovi;
    }

    public void setOdgledaniFilmovi(Set<Film> odgledaniFilmovi) {
        this.odgledaniFilmovi = odgledaniFilmovi;
    }

    public Set<Film> getRezervisaniFilmovi() {
        return rezervisaniFilmovi;
    }

    public void setRezervisaniFilmovi(Set<Film> rezervisaniFilmovi) {
        this.rezervisaniFilmovi = rezervisaniFilmovi;
    }

    public Set<Ocena> getOcenjeniFilmovi() {
        return ocenjeniFilmovi;
    }

    public void setOcenjeniFilmovi(Set<Ocena> ocenjeniFilmovi) {
        this.ocenjeniFilmovi = ocenjeniFilmovi;
    }
}
