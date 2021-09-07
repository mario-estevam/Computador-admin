package com.example.computadoradmin.controller;

import com.example.computadoradmin.model.Gabinete;
import com.example.computadoradmin.service.GabineteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Gabinete getOne(@PathVariable Long id){
        return service.getId(id);
    }

    @PostMapping
    public Gabinete insert(@RequestBody Gabinete g) {
        return service.insert(g);
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
                .map(record -> {
                    service.delete(record);
                    return ResponseEntity.status(202).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
