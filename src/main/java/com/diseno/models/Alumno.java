package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

@Entity
@Getter
@Setter
public class Alumno extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaIngreso;
    @ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name="alumno_cursada",joinColumns=@JoinColumn(name="alumno_id"),inverseJoinColumns=@JoinColumn(name="cursada_id") )
    private Collection<Cursada> cursadas = new ArrayList<>();

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name="EvaluacionRealizada",joinColumns=@JoinColumn(name="alumno_id"),inverseJoinColumns=@JoinColumn(name="id") )
    private Collection<EvaluacionRealizada> evaluacionRealizadas = new ArrayList<>();

    protected boolean estaEvalRealizada(Iterator evaluacionesRealizada, Cursada cursada) {
        while (evaluacionesRealizada.hasNext()) {
            EvaluacionRealizada evaluacionRealizada = (EvaluacionRealizada) evaluacionesRealizada.next();
            if (cursada.getEvaluacionRealizadas().contains(evaluacionRealizada)) {
                return true;
            }
        }
        return false;
    }

    public Collection<Cursada> getCursadasSinEvaluacion(int anio) {
        Collection<Cursada> cursadasPendientes = new ArrayList<>();
        Iterator cursadas = this.cursadas.iterator();
        Iterator evaluaciones = this.evaluacionRealizadas.iterator();
        while (cursadas.hasNext()) {
            Cursada cursada = (Cursada) cursadas.next();
            if (cursada.getAnio() == anio){
                boolean evaluacionRealizada = this.estaEvalRealizada(evaluaciones, cursada);
                if(!evaluacionRealizada) {
                    cursadasPendientes.add(cursada);
                }
            }
        }
        return cursadasPendientes;
    }
}
