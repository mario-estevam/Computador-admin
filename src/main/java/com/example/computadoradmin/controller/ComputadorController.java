package com.example.computadoradmin.controller;


import com.example.computadoradmin.model.Computador;

import com.example.computadoradmin.service.ComputadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController // definindo q é uma aplicação rest
@RequestMapping("/computadores") //o recurso que quero é computador, é utilizado apenas a rota /computador pq a partir dessa rota é recebido um verbo http q irá indicar a ação a ser feita
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class ComputadorController {
    private ComputadorService service;

    public ComputadorController(ComputadorService service){
        this.service = service;
    }

    @GetMapping// quando chegar uma solicitacao do tipo get ele invoca esse metodo
    public List<Computador> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"}) // pra diferenciar do outro get, esse get aqui recebe um parametro q no caso seria o id, pra fazer a busca byId
    public ResponseEntity<Computador> getId(@PathVariable Long id){ // msm q eu mude pra optional aqui e no service, ele dá um status 500 e não dava o retorno correto
        Optional<Computador> c = service.getComputadorById(id);
        if(c.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(c.get());
        }
    }

    @PostMapping
    public ResponseEntity<Computador> insert(@RequestBody Computador computador) {
         service.insert(computador);
         return ResponseEntity.created(URI.create("/computadores/"+computador.getId())).body(computador);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Computador> update(@PathVariable Long id, @RequestBody Computador computador){ // é interessante receber o computador a ser atualizado pq o usuario pode mandar o id 2 e querer atualizar o computador de id 5
        if(service.getId(id) == null){
            return ResponseEntity.notFound().build(); // se nao encontrar a pessoa retorna not found
        }else{
            service.update(computador);
            Computador updated = service.getId(id);
            return ResponseEntity.ok().body(updated); // caso encontre, atualiza e retorna ok
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id) // pegamos o optional
                .map(record -> { // passamos para a função map uma funcao, se er ele manda o 202 de ok se n ele da not found
                    service.delete(record);
                    return ResponseEntity.status(202).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

