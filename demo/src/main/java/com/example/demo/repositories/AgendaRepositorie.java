package com.example.demo.repositories;

import com.example.demo.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepositorie  extends JpaRepository<Agenda, Long> {
}
