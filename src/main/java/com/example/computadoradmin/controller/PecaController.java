package com.example.computadoradmin.controller;


import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.model.Peca;
import com.example.computadoradmin.service.PecaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = {"/{id}"}) // pra diferenciar do outro get, esse get aqui recebe um parametro q no caso seria o id, pra fazer a busca byId
    public ResponseEntity<Peca> getId(@PathVariable Long id){ // msm q eu mude pra optional aqui e no service, ele dá um status 500 e não dava o retorno correto
        Optional<Peca> p = service.getPecaById(id);
        if(p.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(p.get());
        }
    }

    @PostMapping
    public ResponseEntity<Peca> insert(@RequestBody Peca p) {
        service.insert(p);
        return ResponseEntity.created(URI.create("/peca/"+p.getId())).body(p);
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
                .map(record -> { // passamos para a função map uma funcao, se er ele manda o 202 de ok se n ele da not found
                    service.delete(record);
                    return ResponseEntity.status(202).build();
                }).orElse(ResponseEntity.notFound().build());
    }
}