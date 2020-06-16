package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private int kapacitet;
    @Column
    private String oznaka_sale;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ListaProjekcija> terminska_lista_projekcija = new HashSet<ListaProjekcija>();

    public Sala(Long id, int kapacitet, String oznaka_sale, Set<ListaProjekcija> terminska_lista_projekcija) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
        this.terminska_lista_projekcija = terminska_lista_projekcija;
    }

    public Sala(int kapacitet, String oznaka_sale) {
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
    }

    public Sala() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
