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
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    private Set<Film> rezervisaniFilmovi = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ocenjeni_filmovi",
            joinColumns = @JoinColumn(name = "gledalac_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ocenjen_film_id", referencedColumnName = "id"))
    private Set<Ocena> ocenjeniFilmovi = new HashSet<>();


    public Gledalac(Set<Film> odgledaniFilmovi, Set<Film> rezervisaniFilmovi, Set<Ocena> ocenjeniFilmovi) {
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
}
