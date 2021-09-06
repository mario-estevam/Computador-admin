package com.example.computadoradmin.service;


import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputadorService {
    private com.example.computadoradmin.repository.ComputadorRepository ComputadorRepository;

    @Autowired
    private void setComputadorRepository(ComputadorRepository repository){ this.ComputadorRepository = repository; }
    public Computador insert(Computador c){
        return ComputadorRepository.save(c);
    }
    public Computador update(Computador c){
        return ComputadorRepository.save(c);
    }
    public void delete(Computador c){
        ComputadorRepository.delete(c);
    }
    public Computador getOne(Long id){
        return ComputadorRepository.findById(id).orElse(null);
    }
    public Computador SaveAndFlush(Computador c){
        return ComputadorRepository.saveAndFlush(c);
    }

    public Optional<Computador> findById(Long id){
        return ComputadorRepository.findById(id);
    }
    public List<Computador> getAll(){
        return ComputadorRepository.findAll();
    }

}
