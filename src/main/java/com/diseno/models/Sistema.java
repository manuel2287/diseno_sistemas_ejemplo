package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Sistema {
    private List<Alumno> alumnos;
    private List<Evaluacion> evaluaciones;
    private List<EvaluacionRealizada> evaluacionesRealizadas;
    private List<Docente> docentes;
    private List<Director> directores;
    public void addEvaluacionRealizada(EvaluacionRealizada evaluacionRealizada) {

    }
    public Evaluacion getEvaluacion(int anio) {
        return new Evaluacion();
    }
}
