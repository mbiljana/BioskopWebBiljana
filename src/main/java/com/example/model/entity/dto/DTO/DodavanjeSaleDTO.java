package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class DodavanjeSaleDTO implements Serializable {
    private String oznakaSale;
    private int kapacitet;

    public DodavanjeSaleDTO(String oznakaSale, int kapacitet) {
        this.oznakaSale = oznakaSale;
        this.kapacitet = kapacitet;
    }

    public DodavanjeSaleDTO() {
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }
}
