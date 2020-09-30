package com.diseno.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinTable(name = "Alumno", joinColumns=@JoinColumn(name="usuario_id"),inverseJoinColumns=@JoinColumn(name="id"))
    private Alumno alumno;
}
