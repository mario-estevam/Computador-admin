package com.example.computadoradmin.controller;


import com.example.computadoradmin.model.Peca;
import com.example.computadoradmin.service.PecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/peca")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class PecaController {
    private PecaService service;

    public PecaController(PecaService service){this.service = service;}

    @GetMapping
    public List<Peca> listAll(){
        return service.getAll();
    }
    @GetMapping(path = "/{id}")
    public Peca getOne(@PathVariable Long id){return service.getId(id);}
    @PostMapping
    public Peca insert(@RequestBody Peca p){
        return service.insert(p);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Peca> update(@PathVariable Long id, @RequestBody Peca p){
        if(service.getId(id) == null){
            return ResponseEntity.notFound().build();
        }else{
            service.update(p);
            Peca updated = service.getId(id);
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