package com.diseno.services;

import com.diseno.models.Evaluacion;

public interface IEvaluacionService {
    Evaluacion findByAnio(int id);
}
