package com.diseno.controllers;

import com.diseno.forms.RespuestasForm;
import com.diseno.models.Alumno;
import com.diseno.models.Cursada;
import com.diseno.models.Evaluacion;
import com.diseno.models.EvaluacionRealizada;
import com.diseno.services.AlumnoService;
import com.diseno.services.CursadaService;
import com.diseno.services.EvaluacionRealizadaService;
import com.diseno.services.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Controller
public class CTRLEvDoc {
    @Autowired
    AlumnoService alumnoService;

    @Autowired
    CursadaService cursadaService;

    @Autowired
    EvaluacionService evaluacionService;

    @Autowired
    EvaluacionRealizadaService evaluacionRealizadaService;

    @RequestMapping("/")
    public String index(
            @RequestParam(name="user", required=true) int user,
            Model model) {
        model.addAttribute("alumno", user);
        return "home.html";
    }

    @RequestMapping("/evaluacionesPendientes")
    public String evaluacionesPendientes(
            @RequestParam(name="success", required=false) boolean success,
            @RequestParam(name="user", required=true) int user,
            @RequestParam(name="anio", required=true) int anio,
            Model model) {
        Alumno alumno = alumnoService.findById(user);
        Collection<Cursada> cursadas = alumno.getCursadasSinEvaluacion(anio);
        model.addAttribute("cursadas", cursadas);
        model.addAttribute("alumno", alumno);
        return "evaluacionesPendientes.html";
    }

    @GetMapping("/evaluar")
    public String evaluar(
            @RequestParam(name="cursada", required=false) long cursadaId,
            @RequestParam(name="alumno", required=false) long alumnoId,
            Model model) {
        Cursada cursada = cursadaService.findById(cursadaId);
        Evaluacion evaluacion = evaluacionService.findByAnio(cursada.getAnio());
        model.addAttribute("evaluacion", evaluacion);
        model.addAttribute("cursada", cursada);
        model.addAttribute("alumno", alumnoId);
        return "evaluar.html";
    }

    @PostMapping("/guardar")
    public String guardarEvaluacion(
            @ModelAttribute RespuestasForm respuestasForm,
            Model model) {
        Cursada cursada = cursadaService.findById(respuestasForm.getCursada());
        Alumno alumno = alumnoService.findById(respuestasForm.getAlumno());
        try {
            EvaluacionRealizada evaluacionRealizada = new EvaluacionRealizada();
            evaluacionRealizada.setRespuestas(respuestasForm.getRespuestas());
            evaluacionRealizada.setFecha(new Date());
            evaluacionRealizada.setHora(new Time(1));
            evaluacionRealizada.setDocente(cursada.getDocente());
            evaluacionRealizada.setCursada(cursada);
            evaluacionRealizada.setAlumno(alumno);
            evaluacionRealizadaService.saveOrUpdate(evaluacionRealizada);
        } catch (Exception e) {
            System.out.println(e);
        }
        model.addAttribute("alumno", alumno.getId());
        return "success.html";
    }
}
