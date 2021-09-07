package com.example.computadoradmin.repository;

import com.example.computadoradmin.model.Computador;
import org.springframework.data.jpa.repository.JpaRepository;
//o bean é um objeto q o spring vai se encarregar de instanciar ele pra gente
public interface ComputadorRepository extends JpaRepository<Computador, Long> {
}
