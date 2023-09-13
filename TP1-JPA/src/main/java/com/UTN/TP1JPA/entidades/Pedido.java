package com.UTN.TP1JPA.entidades;

import com.UTN.TP1JPA.enums.EstadoPedido;
import com.UTN.TP1JPA.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido extends BaseEntidad{

    //Atributos Clase
    private EstadoPedido estadoPedido;
    private Date fecha;
    private TipoEnvio tipoEnvio;
    private double total;

    //-----------------------------------------------------------------------------------
    //Relación OneToMany Pedido y DetallePedido
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    //orphanRemoval: si yo elimino un Pedido, también se elimina su DetallePedido.

    @JoinColumn(name = "pedido_id")
    //pedido_id es el foreing key en la tabla de DetallePedido.
    //En las relaciones One to Many la foreing key siempre va en la tabla de Many.

    @Builder.Default
    private List<DetallePedido> detallesPedidos = new ArrayList<>();

    //-----------------------------------------------------------------------------------
    //Relación Pedido y Factura
    @OneToOne(orphanRemoval = true, fetch = FetchType.EAGER)

    @JoinColumn(name = "factura_id")

    private Factura factura;

    //-----------------------------------------------------------------------------------
    //Métodos
    public void agregarFactura(Factura fact){

        this.factura = fact;
    }

    public void agregarDetallePedido(DetallePedido detallePedido){

        detallesPedidos.add(detallePedido);
    }

    public void mostrarFactura() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Pedidos id: " + getId());
        if (factura != null) {
            System.out.println("Factura Id: " + factura.getId() + ", Fecha: " + factura.getFecha() + ", Descuento: "
                    + factura.getDescuento() + ", Forma de pago: " + factura.getFormaPago() + ", Total: " +
                    factura.getTotal());
        } else {
            System.out.println("No hay factura asociada a este pedido.");
        }
        }

    public void mostrarDetallePedido() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Pedido id: " + getId());
        for (DetallePedido detallePedido : detallesPedidos) {
            System.out.println("DetallePedido Id: " + detallePedido.getId()  +
                    ", Cantidad: " + detallePedido.getCantidad()  +
                    ", Subtotal: " + detallePedido.getSubtotal());
        }


    }

    }

