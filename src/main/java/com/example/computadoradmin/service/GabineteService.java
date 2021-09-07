package com.example.computadoradmin.service;

import com.example.computadoradmin.model.Gabinete;
import com.example.computadoradmin.repository.GabineteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GabineteService {
    private GabineteRepository gabineteRepository;

    @Autowired
    private void setGabineteRepository(GabineteRepository repository){ this.gabineteRepository = repository; }

    public Gabinete insert(Gabinete g){
        return gabineteRepository.save(g);
    }
    public Gabinete update(Gabinete g){
        return gabineteRepository.save(g);
    }
    public void delete(Gabinete g){
        gabineteRepository.delete(g);
    }
    public Gabinete getId(Long id){
        return gabineteRepository.findById(id).orElse(null);
    }
    public Gabinete SaveAndFlush(Gabinete g){
        return gabineteRepository.saveAndFlush(g);
    }

    public Optional<Gabinete> findById(Long id){
        return gabineteRepository.findById(id);
    }
    public List<Gabinete> getAll(){
        return gabineteRepository.findAll();
    }
}
