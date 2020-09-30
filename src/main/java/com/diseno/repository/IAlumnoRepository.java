package com.diseno.repository;

import com.diseno.models.Alumno;
import com.diseno.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long>  {
    Alumno findById(long id);
}
