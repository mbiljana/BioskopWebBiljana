package com.example.model.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Administrator extends Korisnik{

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Bioskop bioskop;


    public Administrator() {
    }

    public Administrator(Bioskop bioskop) {
        this.bioskop = bioskop;
    }

    public Administrator(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga, Boolean aktivan, Bioskop bioskop) {
        super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
        this.bioskop = bioskop;
    }

    public Bioskop getBioskop() {
        return bioskop;
    }

    public void setBioskop(Bioskop bioskop) {
        this.bioskop = bioskop;
    }
}
