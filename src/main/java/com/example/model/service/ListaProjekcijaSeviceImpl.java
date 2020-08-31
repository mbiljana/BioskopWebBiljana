package com.example.model.service;

import com.example.model.entity.Film;
import com.example.model.entity.ListaProjekcija;
import com.example.model.repository.ListaProjekcijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListaProjekcijaSeviceImpl implements ListaProjekcijaService{
    @Autowired
    private ListaProjekcijaRepository listaProjekcijaRepository;

    @Override
    public List<ListaProjekcija> findAll(){
        return listaProjekcijaRepository.findAll();
    }

    @Override
    public List<ListaProjekcija> findAllByFilm(Film film){
        return listaProjekcijaRepository.findAllByFilm(film);
    }

    @Override
    public ListaProjekcija findOne(Long id) {
        return listaProjekcijaRepository.getOne(id);
    }

    @Override
    public ListaProjekcija findByNazivAndZanr(String naziv, String zanr){
        return listaProjekcijaRepository.findByNazivAndZanr(naziv,zanr);
    }

    @Override
    public ListaProjekcija findByNaziv(String naziv){
        return listaProjekcijaRepository.findByNaziv(naziv);
    }

    @Override
    public List<ListaProjekcija> findAllByFilmId(Long id){
        return listaProjekcijaRepository.findAllByFilmId(id);
    }

    @Override
    public ListaProjekcija findAllByPocetakAndDan(String pocetak, Date dan){
        return listaProjekcijaRepository.findAllByPocetakAndDan(pocetak, dan);
    }

    @Override
    public ListaProjekcija findByPocetak(String pocetak){
        return listaProjekcijaRepository.findByPocetak(pocetak);
    }

    @Override
    public ListaProjekcija findByDan(Date dan){
        return listaProjekcijaRepository.findByDan(dan);
    }

    @Override
    public List<ListaProjekcija>findAllByOrderByNaziv(){
        return listaProjekcijaRepository.findAllByOrderByNaziv();
    }

    @Override
    public List<ListaProjekcija>sortCena(){
        return listaProjekcijaRepository.findAllByOrderByCenaAsc();
    }

    @Override
    public void save(ListaProjekcija listaProjekcija) {
        listaProjekcijaRepository.save(listaProjekcija);
    }

    @Override
    public void delete(ListaProjekcija listaProjekcija) {
        listaProjekcijaRepository.delete(listaProjekcija);
    }


    @Override
    public List<ListaProjekcija>pretraga(String pocetak, String cena, String dan, Film film){
        if(pocetak!="" && cena!="" && dan!="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,cena,dan,film);
        }
        else if(pocetak!="" && cena!="" && dan!="" && film==null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,cena,dan,null);
        }
        else if(pocetak!="" && cena!="" && dan=="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,cena,"",film);
        }
        else if(pocetak!="" && cena=="" && dan!="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,"",dan,film);
        }
        else if(pocetak=="" && cena!="" && dan!="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm("",cena,dan,film);
        }
        //kombinovano film
        else if(pocetak!="" && cena!="" && dan=="" && film==null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,cena,"",null);
        }
        else if(pocetak!="" && cena=="" && dan!="" && film==null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,"",dan,null);
        }
        else if(pocetak=="" && cena!="" && dan!="" && film==null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm("",cena,dan,null);
        }
        //dan
        else if(pocetak!="" && cena=="" && dan=="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm(pocetak,"","",film);
        }
        else if(pocetak=="" && cena!="" && dan=="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm("",cena,"",film);
        }
        //cena i pocetak
        else if(pocetak=="" && cena=="" && dan!="" && film!=null){
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm("","",dan,film);
        }
        else {
            return listaProjekcijaRepository.findAllByPocetakOrCenaOrDanOrFilm("", "", "", null);
        }
    }












}
