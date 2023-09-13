package com.UTN.TP1JPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Rubro extends BaseEntidad {

    //Atributos Clase
    private String denominacion;

    //-----------------------------------------------------------------------------------
    //Relación OneToMany Rubro y Producto
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    //rubro_id es el foreing key en la tabla de Producto.

    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    //-----------------------------------------------------------------------------------
    //Métodos

    public void agregarProducto(Producto prod){

        productos.add(prod);
    }

    public void mostrarProductos() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Rubro Id " + getId());
        for (Producto producto : productos) {
            System.out.println("Producto Id: " + producto.getId() +", Tipo de Producto: " + producto.getTipoProducto() +
                    ", Tiempo Estimado Cocina: " + producto.getTiempoEstimadoCocina() + ", Denomicación: " +
                    producto.getDenominacion() + ", Precio de venta: " + producto.getPrecioVenta() +
                    ", Precio de compra: " + producto.getPrecioCompra() + ", Stock actual: " + producto.getStockActual()
                    + ", Precio de mínimo: " + producto.getStockMinimo() + ", Unidad de medida: " + producto.getUnidadMedida()
                    + ", Receta: " + producto.getReceta());
        }

    }
}
