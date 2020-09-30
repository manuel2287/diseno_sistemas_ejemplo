package com.diseno.services;

import com.diseno.models.Alumno;

public interface IAlumnoService {
    Alumno findById(long id);
    void saveOrUpdate(Alumno alumno);
}
