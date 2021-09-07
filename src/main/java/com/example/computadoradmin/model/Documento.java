package com.example.computadoradmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String montado_por;
    Long cod_montagem;
    /*
     @OneToOne
     @MapsId
     @JoinColum(name = "computador_id")
     Computador computador
     */
}
