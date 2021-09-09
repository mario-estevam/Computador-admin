package com.example.computadoradmin.service;


import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.repository.ComputadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // essa classe passa a ser um bean, e toda vez que o projeto for inicializado o spring incializa essa classe tb
public class ComputadorService {
    private ComputadorRepository computadorRepository;

    @Autowired // computador repository é um bean, ai vamos usar a injeção de dependencia pra que aquele bean q ta na memoria passe a entrar nesas classe toda vez que essa classe for istanciada
    private void setComputadorRepository(ComputadorRepository repository){ this.computadorRepository = repository; }
    public Computador insert(Computador computador){
        return computadorRepository.save(computador);
    }
    public Optional<Computador> getComputadorById(Long id){
        return computadorRepository.findById(id);
    }
    public Computador update(Computador computador){
        return computadorRepository.save(computador);
    }
    public void delete(Computador computador){
        computadorRepository.delete(computador);
    }
    public Computador getId(Long id){
        return computadorRepository.findById(id).orElse(null);
    }
    public List<Computador> getAll(){
        return computadorRepository.findAll();
    }

}
