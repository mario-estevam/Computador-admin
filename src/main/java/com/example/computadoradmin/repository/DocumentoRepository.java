package com.example.computadoradmin.repository;

import com.example.computadoradmin.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
