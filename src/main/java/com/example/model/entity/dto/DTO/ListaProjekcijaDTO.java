package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class ListaProjekcijaDTO implements Serializable {
    private Long id;
    private String  danProjekcije;
    private String pocetak;
    private String cena;
    private String nazivFilma;
    private String zanrFilma;
    private String trajanjeFilma;
    private String opisFilma;
    private Double ocena;
    private int brojRezervisanih;
    private int kapacitetSale;



    public ListaProjekcijaDTO(Long id, String danProjekcije, String pocetak, String cena, String nazivFilma, String zanrFilma, String trajanjeFilma, String opisFilma) {
        this.id = id;
        this.danProjekcije = danProjekcije;
        this.pocetak = pocetak;
        this.cena = cena;
        this.nazivFilma = nazivFilma;
        this.zanrFilma = zanrFilma;
        this.trajanjeFilma = trajanjeFilma;
        this.opisFilma = opisFilma;

    }
    public ListaProjekcijaDTO(Long id, String danProjekcije, String pocetak, String cena, String nazivFilma, String zanrFilma, String trajanjeFilma, String opisFilma, Double ocena) {
        this.id = id;
        this.danProjekcije = danProjekcije;
        this.pocetak = pocetak;
        this.cena = cena;
        this.nazivFilma = nazivFilma;
        this.zanrFilma = zanrFilma;
        this.trajanjeFilma = trajanjeFilma;
        this.opisFilma = opisFilma;
        this.ocena=ocena;
    }

    public ListaProjekcijaDTO(String danProjekcije, String pocetak, String cena, String nazivFilma, String zanrFilma, String trajanjeFilma, String opisFilma, Double ocena, int brojRezervisanih) {
        this.danProjekcije = danProjekcije;
        this.pocetak = pocetak;
        this.cena = cena;
        this.nazivFilma = nazivFilma;
        this.zanrFilma = zanrFilma;
        this.trajanjeFilma = trajanjeFilma;
        this.opisFilma = opisFilma;
        this.ocena = ocena;
        this.brojRezervisanih = brojRezervisanih;
    }

    public int getKapacitetSale() {
        return kapacitetSale;
    }

    public void setKapacitetSale(int kapacitetSale) {
        this.kapacitetSale = kapacitetSale;
    }

    public int getBrojRezervisanih() {
        return brojRezervisanih;
    }

    public void setBrojRezervisanih(int brojRezervisanih) {
        this.brojRezervisanih = brojRezervisanih;
    }

    public ListaProjekcijaDTO() {
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDanProjekcije() {
        return danProjekcije;
    }

    public void setDanProjekcije(String danProjekcije) {
        this.danProjekcije = danProjekcije;
    }

    public String getPocetak() {
        return pocetak;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getNazivFilma() {
        return nazivFilma;
    }

    public void setNazivFilma(String nazivFilma) {
        this.nazivFilma = nazivFilma;
    }

    public String getZanrFilma() {
        return zanrFilma;
    }

    public void setZanrFilma(String zanrFilma) {
        this.zanrFilma = zanrFilma;
    }

    public String getTrajanjeFilma() {
        return trajanjeFilma;
    }

    public void setTrajanjeFilma(String trajanjeFilma) {
        this.trajanjeFilma = trajanjeFilma;
    }

    public String getOpisFilma() {
        return opisFilma;
    }

    public void setOpisFilma(String opisFilma) {
        this.opisFilma = opisFilma;
    }
}
