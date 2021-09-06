package com.example.computadoradmin.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity


public class Computador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String modelo;
    Integer ano;
    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "kitupgrader_id")
    Gabinete gabinete;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registro_id")
    Documento documento;
}
