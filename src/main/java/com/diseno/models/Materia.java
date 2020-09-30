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
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String carrera;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Cursada",joinColumns=@JoinColumn(name="materia_id"),inverseJoinColumns=@JoinColumn(name="id"))
    private Collection<Cursada> cursadas = new ArrayList<>();
}
