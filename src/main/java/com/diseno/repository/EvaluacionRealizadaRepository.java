package com.diseno.repository;

import com.diseno.models.Cursada;
import com.diseno.models.EvaluacionRealizada;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class EvaluacionRealizadaRepository implements IEvaluacionRealizadaRepositoryCustom {
    private EntityManager em;

    public EvaluacionRealizadaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    @Modifying
    public EvaluacionRealizada save(EvaluacionRealizada evaluacionRealizada) {
        em.persist(evaluacionRealizada);
        em.flush();
        return null;
    }
}
