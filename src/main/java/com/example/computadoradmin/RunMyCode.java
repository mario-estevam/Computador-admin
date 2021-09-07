
package com.example.computadoradmin;
/*
import com.example.computadoradmin.model.Computador;
import com.example.computadoradmin.model.Documento;
import com.example.computadoradmin.model.Gabinete;
import com.example.computadoradmin.model.Peca;
import com.example.computadoradmin.repository.ComputadorRepository;
import com.example.computadoradmin.repository.DocumentoRepository;
import com.example.computadoradmin.repository.GabineteRepository;
import com.example.computadoradmin.repository.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Component
public class RunMyCode implements ApplicationRunner {

    @Autowired
    ComputadorRepository computadorRepository;
    @Autowired
    GabineteRepository gabineteRepository;
    @Autowired
    PecaRepository pecaRepository;
    @Autowired
    DocumentoRepository documentoRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Gabinete g1 = new Gabinete();
        Computador c1 = new Computador();
        Peca p1 = new Peca();
        Documento d1 = new Documento();
        g1.setModelo("midtower");
        g1.setMarca("Pichau");
        p1.setNome("placa mae");
        c1.setGabinete(g1);
        d1.setMontado_por("mario");
        d1.setCod_montagem(12121L);
        c1.setFabricante("KABUM");
        List<Gabinete> gabinetes = new ArrayList<>();
        List<Computador> computadors = new ArrayList<>();
        gabinetes.add(g1);
        computadors.add(c1);
        gabineteRepository.save(g1);
        computadorRepository.save(c1);
        pecaRepository.save(p1);


    }


}
*/


