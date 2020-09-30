package com.diseno.repository;

import com.diseno.models.Alumno;
import com.diseno.models.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursadaRepository extends JpaRepository<Cursada, Long> {
    Cursada findById(long id);
}
