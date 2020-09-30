package com.diseno.repository;

import com.diseno.models.EvaluacionRealizada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEvaluacionRealizadaRepository extends JpaRepository<EvaluacionRealizada, Long>, IEvaluacionRealizadaRepositoryCustom, JpaSpecificationExecutor<EvaluacionRealizada> {
}
