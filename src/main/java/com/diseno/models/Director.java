package com.diseno.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
public class Director extends Persona {
    private Date fechaInicio;
}
