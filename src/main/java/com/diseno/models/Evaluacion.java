package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int anio;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Pregunta_evaluacion",joinColumns=@JoinColumn(name="evaluacion_id"),inverseJoinColumns=@JoinColumn(name="pregunta_id"))
    private Collection<Pregunta> preguntas = new ArrayList<>();
    public List<EvaluacionRealizada> buscarPyREval(int idEncuesta){
        return null;
    }
}
