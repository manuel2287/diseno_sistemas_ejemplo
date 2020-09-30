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
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripPgta;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Respuesta_Pregunta",joinColumns=@JoinColumn(name="pregunta_id"),inverseJoinColumns=@JoinColumn(name="respuesta_id"))
    private Collection<Respuesta> respuestas = new ArrayList<>();
}
