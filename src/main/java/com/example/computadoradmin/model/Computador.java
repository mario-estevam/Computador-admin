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
    String Tipo;
    String Fabricante;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "gabinete_id")
    Gabinete gabinete;

    @OneToOne(cascade = CascadeType.ALL) //por padrão o fetch é EAGER
    @JoinColumn(name = "documento_id")
    Documento documento;
}
