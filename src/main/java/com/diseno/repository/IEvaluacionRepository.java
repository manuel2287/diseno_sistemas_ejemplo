package com.diseno.repository;

import com.diseno.models.Evaluacion;
import com.diseno.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IEvaluacionRepository  extends JpaRepository<Evaluacion, Long>, IEvaluacionRepositoryCustom, JpaSpecificationExecutor<Evaluacion> {
}
