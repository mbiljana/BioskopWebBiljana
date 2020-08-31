package com.example.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Menadzer extends Korisnik{

    @OneToMany(mappedBy = "menadzer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bioskop> bioskopList=new ArrayList<>();

    public List<Bioskop> getBioskopi() {
        return bioskopList;
    }
    public void setBioskopi(List<Bioskop> bioskopList) {
        this.bioskopList = bioskopList;
    }




    public Menadzer() {

    }

    public Menadzer(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String kontaktTelefon, String e_mail, Date datumRodjenja, EnumUloga uloga, Boolean aktivan, List<Bioskop> bioskopList) {
        super(id, korisnickoIme, lozinka, ime, prezime, kontaktTelefon, e_mail, datumRodjenja, uloga, aktivan);
        this.bioskopList = bioskopList;
    }

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga, Boolean aktivan, List<Bioskop> bioskopList) {
        super(korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
        this.bioskopList = bioskopList;
    }

    public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, String e_mail, Date datum_rodjenja, EnumUloga uloga, Boolean aktivan) {
        super(korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, e_mail, datum_rodjenja, uloga, aktivan);
    }
}
