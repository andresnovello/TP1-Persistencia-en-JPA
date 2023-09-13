package com.UTN.TP1JPA.entidades;

import com.UTN.TP1JPA.enums.FormaPago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Factura extends BaseEntidad{

    //Atributos Clase
    private int numero;
    private Date fecha;
    private double descuento;
    private FormaPago formaPago;
    private int total;

    //Métodos

}
