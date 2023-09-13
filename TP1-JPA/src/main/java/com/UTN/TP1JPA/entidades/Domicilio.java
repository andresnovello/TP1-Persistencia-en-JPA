package com.UTN.TP1JPA.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Domicilio extends BaseEntidad {

    //Atributos Clase
    private String calle;
    private String numero;
    private String localidad;

    /*
    private Cliente cliente;
    public Cliente getCliente() {
        return cliente;
    }
    */


}
