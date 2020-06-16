package com.example.model.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Menadzer extends Korisnik{

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Bioskop bioskop;


    public Menadzer(Bioskop bioskop) {
        this.bioskop = bioskop;
    }

    public Menadzer() {

    }

    public Menadzer(Long id, String korisnicko_ime, String lozinka, String ime, String prezime,
                    String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga,
                    Boolean aktivan, Bioskop bioskop) {
        super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
        this.bioskop = bioskop;
    }
    public Menadzer( String korisnicko_ime, String lozinka, String ime, String prezime,
                    String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga,
                    Boolean aktivan) {
        super( korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
    }

    public Bioskop getBioskop() {
        return bioskop;
    }

    public void setBioskop(Bioskop bioskop) {
        this.bioskop = bioskop;
    }
}
