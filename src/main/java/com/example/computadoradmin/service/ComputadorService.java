package com.example.computadoradmin.service;


import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // essa classe passa a ser um bean, e toda vez que o projeto for inicializado o spring incializa essa classe tb
public class ComputadorService {
    private ComputadorRepository ComputadorRepository;

    @Autowired // computador repository é um bean, ai vamos usar a injeção de dependencia pra que aquele bean q ta na memoria passe a entrar nesas classe toda vez que essa classe for istanciada
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
    public Computador getId(Long id){
        return ComputadorRepository.findById(id).orElse(null);
    }
    public Optional<Computador> findById(Long id){
        return ComputadorRepository.findById(id);
    }
    public List<Computador> getAll(){
        return ComputadorRepository.findAll();
    }

}
