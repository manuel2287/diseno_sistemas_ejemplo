package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
public class Docente extends Persona {
    private Date anioIngreso;
    private String cargo;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable(name="Cursada",joinColumns=@JoinColumn(name="id"),inverseJoinColumns=@JoinColumn(name="docente_id"))
    private Collection<Cursada> cursadas;
}
