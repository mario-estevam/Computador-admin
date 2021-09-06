package com.example.computadoradmin.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String tipo;
    @ManyToMany
    @JoinTable(
            name = "peca_gabinete", joinColumns = @JoinColumn(name = "peca_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "gabinete_id")
    )
    List<Gabinete> gabinete;

    public Long getId(){
        return id;
    }

}
