package com.example.model.service;

import com.example.model.entity.Ocena;
import com.example.model.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class OcenaServiceImpl implements OcenaService{

    @Autowired
    private OcenaRepository ocenaRepository;

    @Override
    public Ocena create(Ocena ocena){
        this.ocenaRepository.save(ocena);
        return ocena;
    }


    @Override
    public List<Ocena>findAll(){
        return this.ocenaRepository.findAll();
    }

    @Override
    public List<Ocena>getbyID(Long id){
        List<Ocena>ocene=new ArrayList<>();
        for(Ocena o:this.ocenaRepository.findAll()){
            if(o.getGledalac().getId()==id){
                ocene.add(o);
            }
        }
        return ocene;
    }

    @Override
    public List<Ocena>getByFilmID(Long id){
        List<Ocena>ocene=new ArrayList<>();
        for(Ocena o:this.ocenaRepository.findAll()){
            if(o.getFilm().getId()==id){
                ocene.add(o);
            }
        }
        return ocene;
    }

}
