package com.alonso.forohub.repository;

import com.alonso.forohub.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}