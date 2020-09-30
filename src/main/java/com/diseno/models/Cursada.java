package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Entity
@Getter
@Setter
public class Cursada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int anio;
    private int nivel;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="EvaluacionRealizada",joinColumns=@JoinColumn(name="cursada_id"),inverseJoinColumns=@JoinColumn(name="id"))
    private Collection<EvaluacionRealizada> evaluacionRealizadas = new ArrayList<>();

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="id")
    private Docente docente;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="id")
    private Materia materia;
}
