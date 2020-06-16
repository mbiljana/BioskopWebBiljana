package com.example.model.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListaProjekcija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String film;
    @Column
    private String dan;
    @Column
    private String cena;

    @ManyToMany
    private Set<Film> filmovi = new HashSet<>();

    public ListaProjekcija() {

    }


    public ListaProjekcija(Long id, String film, String dan, String cena) {
        this.id = id;
        this.film = film;
        this.dan = dan;
        this.cena = cena;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "ListaProjekcija{" +
                "film='" + film + '\'' +
                ", dan='" + dan + '\'' +
                ", cena='" + cena + '\'' +
                '}';
    }
}
