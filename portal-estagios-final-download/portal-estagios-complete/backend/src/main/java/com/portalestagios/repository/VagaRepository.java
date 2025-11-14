package com.portalestagios.repository;

import com.portalestagios.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByArea(String area);
    List<Vaga> findByEncerradaFalse();
}
