package com.diseno.services;

import com.diseno.models.Cursada;
import com.diseno.repository.ICursadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursadaService implements  ICursadaService{
    @Autowired
    ICursadaRepository cursadaRepository;

    @Override
    public Cursada findById(long id) {
        return  cursadaRepository.findById(id);
    }
}
