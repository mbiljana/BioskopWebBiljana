package com.example.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Repertoar implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="bioskop_id")
    private Bioskop bioskop;
    @ManyToOne
    @JoinColumn(name="lista_id")
    private ListaProjekcija listaProjekcija;
}
