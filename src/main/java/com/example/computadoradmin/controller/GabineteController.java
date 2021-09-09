package com.example.computadoradmin.controller;

import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.model.Gabinete;
import com.example.computadoradmin.service.GabineteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gabinete")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class GabineteController {
    private GabineteService service;

    public GabineteController(GabineteService service){
        this.service = service;
    }

    @GetMapping
    public List<Gabinete> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Gabinete> getId(@PathVariable Long id){ // msm q eu mude pra optional aqui e no service, ele dá um status 500 e não dava o retorno correto
        Optional<Gabinete> g = service.getGabineteById(id);
        if(g.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(g.get());
        }
    }

    @PostMapping
    public ResponseEntity<Gabinete> insert(@RequestBody Gabinete g) {
        service.insert(g);
        return ResponseEntity.created(URI.create("/gabinete/"+g.getId())).body(g);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Gabinete> update(@PathVariable Long id, @RequestBody Gabinete g){
        if(service.getId(id) == null){
            return ResponseEntity.notFound().build();
        }else{
            service.update(g);
            Gabinete updated = service.getId(id);
            return ResponseEntity.ok().body(updated);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map(record -> { // passamos para a função map uma funcao, se er ele manda o 202 de ok se n ele da not found
                    service.delete(record);
                    return ResponseEntity.status(202).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
