package com.example.computadoradmin.controller;


import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.model.Documento;
import com.example.computadoradmin.service.ComputadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/computador")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class ComputadorController {
    private ComputadorService service;

    public ComputadorController(ComputadorService service){
        this.service = service;
    }

    @GetMapping
    public List<Computador> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public Computador getOne(@PathVariable Long id){
        return service.getOne(id);
    }

    @PostMapping
    public Computador insert(@RequestBody Computador c) {
        Documento d1 = new Documento();
        c.setDocumento(d1);
        return service.insert(c);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Computador> update(@PathVariable Long id, @RequestBody Computador c){
        if(service.getOne(id) == null){
            return ResponseEntity.notFound().build();
        }else{
            service.update(c);
            Computador updated = service.getOne(id);
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
