package com.diseno.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Transactional
public class EvaluacionRealizada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha;
    private Time hora;

    @ManyToMany(cascade = {CascadeType.MERGE} ,fetch = FetchType.EAGER)
    @JoinTable(name="respuesta_seleccionada",joinColumns=@JoinColumn(name="evaluacion_realizada_id"),inverseJoinColumns=@JoinColumn(name="respuesta_id"))
    private Collection<Respuesta> respuestas = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="docente_id")
    private Docente docente;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="cursada_id", nullable = false)
    private Cursada cursada;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="alumno_id", nullable = false)
    private Alumno alumno;
}
