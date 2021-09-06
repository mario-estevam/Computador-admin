package com.example.computadoradmin.repository;

import com.example.computadoradmin.model.Computador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputadorRepository extends JpaRepository<Computador, Long> {
}
