package com.example.computadoradmin.service;

import com.example.computadoradmin.model.Gabinete;
import com.example.computadoradmin.model.Peca;
import com.example.computadoradmin.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PecaService {
    private PecaRepository pecaRepository;

    @Autowired
    private void setPecaRepository(PecaRepository repository){this.pecaRepository = repository;}

    public Peca insert(Peca p){
        return pecaRepository.save(p);
    }
    public Peca update(Peca p){
        return pecaRepository.save(p);
    }
    public void delete(Peca p){
        pecaRepository.delete(p);
    }
    public Optional<Peca> getPecaById(Long id){
        return pecaRepository.findById(id);
    }
    public Peca getId(Long id){
        return pecaRepository.findById(id).orElse(null);
    }
    public List<Peca> getAll(){
        return pecaRepository.findAll();
    }
}
