package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private int kapacitet;
    @Column
    private String oznakaSale;


    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ListaProjekcija> terminska_lista_projekcija = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Bioskop bioskop;

    public Bioskop getBioskop() {
        return bioskop;
    }


    public void setBioskop(Bioskop bioskop) {
        this.bioskop = bioskop;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "filmoviSala",
    joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"))
    private Set<Film> filmoviSala = new HashSet<>();





    public Sala(int kapacitet, String oznakaSale, Bioskop bioskop) {
        super();
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.bioskop = bioskop;
    }

    public Sala(Long id, int kapacitet, String oznakSale, List<ListaProjekcija> terminska_lista_projekcija) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
        this.terminska_lista_projekcija = terminska_lista_projekcija;
    }

    public Sala(int kapacitet, String oznaka_sale) {
        this.kapacitet = kapacitet;
        this.oznakaSale = oznaka_sale;
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
        return oznakaSale;
    }

    public void setOznaka_sale(String oznaka_sale) {
        this.oznakaSale = oznaka_sale;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public List<ListaProjekcija> getTerminska_lista_projekcija() {
        return terminska_lista_projekcija;
    }

    public void setTerminska_lista_projekcija(List<ListaProjekcija> terminska_lista_projekcija) {
        this.terminska_lista_projekcija = terminska_lista_projekcija;
    }

    public Set<Film> getFilmoviSala() {
        return filmoviSala;
    }

    public void setFilmoviSala(Set<Film> filmoviSala) {
        this.filmoviSala = filmoviSala;
    }
}
