package com.example.model.entity.dto.DTO;

import java.io.Serializable;

public class SalaDTO implements Serializable {
    private Long id;
    private int kapacitet;
    private String oznaka_sale;

    public SalaDTO(int kapacitet, String oznaka_sale) {
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
    }

    public SalaDTO() {
    }

    public SalaDTO(Long id, int kapacitet, String oznaka_sale) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SalaDTO{" +
                "kapacitet=" + kapacitet +
                ", oznaka_sale='" + oznaka_sale + '\'' +
                '}';
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka_sale() {
        return oznaka_sale;
    }

    public void setOznaka_sale(String oznaka_sale) {
        this.oznaka_sale = oznaka_sale;
    }
}
