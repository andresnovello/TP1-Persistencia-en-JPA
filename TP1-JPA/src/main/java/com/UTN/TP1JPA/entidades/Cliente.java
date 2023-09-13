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

public class Cliente extends BaseEntidad {

    //Atributos Clase
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //-----------------------------------------------------------------------------------
    //Relación OneToMany Cliente y Domicilio
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    //orphanRemoval: si yo elimino un Cliente, también se elimina su domicilio.

    @JoinColumn(name = "cliente_id")
    //cliente_id es el foreing key en la tabla de Domicilio.
    //En las relaciones One to Many la foreing key siempre va en la tabla de Many.

    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    //-----------------------------------------------------------------------------------
    //Relación OneToMany Cliente y Pedido
    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    //orphanRemoval: si yo elimino un Cliente, también se elimina su pedido.

    @JoinColumn(name = "cliente_id")
    //cliente_id es el foreing key en la tabla de Pedido.

    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    //-----------------------------------------------------------------------------------
    //Métodos

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }


    public void agregarPedido(Pedido pedido){

        pedidos.add(pedido);
    }

    public void mostrarDomicilios() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero() +
                    ", Localidad: " + domicilio.getLocalidad());
        }


    }

    public void mostrarPedidos() {
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido Id: " + pedido.getId() +", Estado: " + pedido.getEstadoPedido() + ", Fecha: " + pedido.getFecha() +
                    ", Tipo de envío: " + pedido.getTipoEnvio() + ", Tota: " + pedido.getTotal());
        }

    }

}


