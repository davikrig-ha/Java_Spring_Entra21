package com.entra21.repositories;

import com.entra21.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    @Query("Select t from Topico t where t.curso.nome = :nomeCurso")
    List<Topico> carregarPorNomeDoCurso(String nomeCurso);

}
