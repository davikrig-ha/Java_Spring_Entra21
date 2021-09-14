package com.entra21.repositories;

import com.entra21.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> carregarPorNomeDoCurso(String nomeCurso);

}
