package com.diseno.forms;

import com.diseno.models.Docente;
import com.diseno.models.EvaluacionRealizada;
import com.diseno.models.Respuesta;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@Setter
@Getter
public class RespuestasForm {
    private long cursada;
    private long alumno;
    private String pregunta_1;
    private String pregunta_2;
    private String pregunta_3;
    private String pregunta_4;
    private String pregunta_5;

    public Collection<Respuesta> getRespuestas() {
        String[] preguntas = { pregunta_1, pregunta_2, pregunta_3, pregunta_4, pregunta_5 };
        Collection<Respuesta> respuestas = new ArrayList<Respuesta>();
        Iterator<String> preg = Arrays.stream(preguntas).iterator();
        while (preg.hasNext()){
            String[] pregunta = preg.next().split("_");
            Respuesta respuesta = new Respuesta(Long.valueOf(pregunta[0]), pregunta[1]);
            respuestas.add(respuesta);
        }
        return  respuestas;
    }
}
