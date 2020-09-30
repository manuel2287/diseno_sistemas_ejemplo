package com.diseno.services;

import com.diseno.models.Alumno;
import com.diseno.repository.IAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService implements IAlumnoService {
    @Autowired
    private IAlumnoRepository alumnoRepository;
    @Override
    public Alumno findById(long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public void saveOrUpdate(Alumno alumno) {
        alumnoRepository.save(alumno);
    }
}
