package com.example.model.DTO;

import javax.persistence.Column;
import java.io.Serializable;

public class SalaDTO implements Serializable {
    private int kapacitet;
    private String oznaka_sale;

    public SalaDTO(int kapacitet, String oznaka_sale) {
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
    }

    public SalaDTO() {
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
