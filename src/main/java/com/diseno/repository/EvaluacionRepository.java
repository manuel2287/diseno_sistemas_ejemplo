package com.diseno.repository;

import com.diseno.models.Evaluacion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EvaluacionRepository implements IEvaluacionRepositoryCustom{
    private EntityManager em;

    public EvaluacionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Evaluacion findByAnio(int anio) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Evaluacion> cq = cb.createQuery(Evaluacion.class);

        Root<Evaluacion> evaluacionRoot = cq.from(Evaluacion.class);
        List<Predicate> predicates = new ArrayList<>();


        predicates.add(cb.equal(evaluacionRoot.get("anio"), anio));
        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Evaluacion> query = em.createQuery(cq);
        return query.getSingleResult();
    }
}
