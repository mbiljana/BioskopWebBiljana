package com.example.model.service;

import com.example.model.entity.Administrator;
import com.example.model.repository.AdministratorRepository;
import com.example.model.repository.BioskopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService{
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private BioskopRepository bioskopRepository;

    @Override
    public List<Administrator>findAll(){
        List<Administrator> administrator = this.administratorRepository.findAll();
        return administrator;
    }

    @Override
    public Administrator findOne(long id){
        Administrator administrator=this.administratorRepository.getOne(id);
        return administrator;
    }

}
