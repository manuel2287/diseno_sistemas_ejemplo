package com.diseno.repository;

import com.diseno.models.Evaluacion;

public interface IEvaluacionRepositoryCustom {
    Evaluacion findByAnio(int anio);
}
