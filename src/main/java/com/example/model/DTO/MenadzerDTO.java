package com.example.model.DTO;

import com.example.model.entity.Bioskop;

import java.io.Serializable;

public class MenadzerDTO implements Serializable {
    private Bioskop bioskop;

    public MenadzerDTO() {
    }

    public MenadzerDTO(Bioskop bioskop) {
        this.bioskop = bioskop;
    }

    public Bioskop getBioskop() {
        return bioskop;
    }

    public void setBioskop(Bioskop bioskop) {
        this.bioskop = bioskop;
    }
}
