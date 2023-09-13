package com.UTN.TP1JPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DetallePedido extends BaseEntidad {

    //Atributos Clase
    private int cantidad;
    private double subtotal;

    //-----------------------------------------------------------------------------------
    //Relación ManyToOne DetallePedido y Producto
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    //producto_id es el foreing key en la tabla de DetallePedido.
    //En las relaciones Many to one la foreing key va en la tabla de Many.

    private Producto producto;

    //-----------------------------------------------------------------------------------
    //Métodos
    public void agregarProducto(Producto prod){

        this.producto = prod;
    }
}
