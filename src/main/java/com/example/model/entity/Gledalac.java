package com.example.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@DiscriminatorValue("Gledalac")
public class Gledalac extends Korisnik {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "odgledani_filmovi",
            joinColumns = @JoinColumn(name = "gledalac_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    private Set<Film> odgledaniFilmovi = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rezervisani_filmovi",
            joinColumns = @JoinColumn(name = "gledalac_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
    private Set<ListaProjekcija> rezervisaniFilmovi = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ocenjeni_filmovi",
            joinColumns = @JoinColumn(name = "gledalac_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocenjen_film_id", referencedColumnName = "id"))
    private Set<Ocena> ocenjeniFilmovi = new HashSet<>();


    public Gledalac(Set<Film> odgledaniFilmovi, Set<ListaProjekcija> rezervisaniFilmovi, Set<Ocena> ocenjeniFilmovi) {
        this.odgledaniFilmovi = odgledaniFilmovi;
        this.rezervisaniFilmovi = rezervisaniFilmovi;
        this.ocenjeniFilmovi = ocenjeniFilmovi;
    }

    public Gledalac() {

    }

    public Gledalac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime,
                    String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga,
                    Boolean aktivan) {
        super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
    }
    public Gledalac( String korisnicko_ime, String lozinka, String ime, String prezime,
                    String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga,
                    Boolean aktivan) {
        super( korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
    }

    public Set<Film> getOdgledaniFilmovi() {
        return odgledaniFilmovi;
    }

    public void setOdgledaniFilmovi(Set<Film> odgledaniFilmovi) {
        this.odgledaniFilmovi = odgledaniFilmovi;
    }

    public Set<ListaProjekcija> getRezervisaniFilmovi() {
        return rezervisaniFilmovi;
    }

    public void setRezervisaniFilmovi(Set<ListaProjekcija> rezervisaniFilmovi) {
        this.rezervisaniFilmovi = rezervisaniFilmovi;
    }

    public Set<Ocena> getOcenjeniFilmovi() {
        return ocenjeniFilmovi;
    }

    public void setOcenjeniFilmovi(Set<Ocena> ocenjeniFilmovi) {
        this.ocenjeniFilmovi = ocenjeniFilmovi;
    }
}
