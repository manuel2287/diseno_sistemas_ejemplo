package com.diseno.services;

import com.diseno.models.Evaluacion;
import com.diseno.repository.IEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionService implements IEvaluacionService {
    @Autowired
    IEvaluacionRepository evaluacionRepository;

    @Override
    public Evaluacion findByAnio(int anio) {
        return evaluacionRepository.findByAnio(anio);
    }
}
