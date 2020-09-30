package com.diseno.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Transactional
public class Respuesta {

    public  Respuesta(){}

    public Respuesta(Long id, String descripRta) {
        this.id = id;
        this.descripRta = descripRta;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripRta;
}
