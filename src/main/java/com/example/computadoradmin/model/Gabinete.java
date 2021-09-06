package com.example.computadoradmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Gabinete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String modelo;
    public Long getId(){
        return id;
    }
}
