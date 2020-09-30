package com.diseno.services;

import com.diseno.models.EvaluacionRealizada;
import com.diseno.repository.IEvaluacionRealizadaRepository;
import com.diseno.repository.IEvaluacionRealizadaRepositoryCustom;
import com.diseno.repository.IEvaluacionRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionRealizadaService implements IEvaluacionRealizadaService{
    @Autowired
    IEvaluacionRealizadaRepositoryCustom evaluacionRealizadaRepository;
    @Override
    public void saveOrUpdate(EvaluacionRealizada evaluacionRealizada) {
        evaluacionRealizadaRepository.save(evaluacionRealizada);
    }
}
