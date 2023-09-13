package com.UTN.TP1JPA;

import com.UTN.TP1JPA.entidades.*;
import com.UTN.TP1JPA.repositorios.*;


import com.UTN.TP1JPA.enums.EstadoPedido;
import com.UTN.TP1JPA.enums.FormaPago;
import com.UTN.TP1JPA.enums.TipoEnvio;
import com.UTN.TP1JPA.enums.TipoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class Tp1JpaApplication {

	@Autowired
	ClienteRepositorio clienteRepositorio;
	@Autowired
	DomicilioRepositorio domicilioRepositorio;
	@Autowired
	PedidoRepositorio pedidoRepositorio;
	@Autowired
	FacturaRepositorio facturaRepositorio;
	@Autowired
	DetallePedidoRepositorio detallePedidoRepositorio;
	@Autowired
	ProductoRepositorio productoRepositorio;
	@Autowired
	RubroRepositorio rubroRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(Tp1JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ClienteRepositorio clienteRepo, DomicilioRepositorio domicilioRepo,
						   PedidoRepositorio pedidoRepo, FacturaRepositorio facturaRepo,
						   DetallePedidoRepositorio detallePedidoRepo, ProductoRepositorio productoRepo,
						   RubroRepositorio rubroRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			// Crear instancias de Domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero("123")
					.localidad("Mendoza")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero("456")
					.localidad("Luján de Cuyo")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Calle 3")
					.numero("789")
					.localidad("Godoy Cruz")
					.build();

			// Guardar los domicilios en la base de datos
			domicilioRepositorio.save(domicilio1);
			domicilioRepositorio.save(domicilio2);
			domicilioRepositorio.save(domicilio3);

			// Crear instancias de Cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.telefono("2615820074")
					.email("cliente1@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Luis")
					.apellido("Sanchez")
					.telefono("2615825478")
					.email("cliente2@gmail.com")
					.build();

			// Agregar domicilios a los clientes
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio3);
			cliente2.agregarDomicilio(domicilio2);

			// Guardar los clientes en la base de datos
			clienteRepositorio.save(cliente1);
			clienteRepositorio.save(cliente2);

			//Le doy formato a Date
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha1 = "2023-09-10";
			String fecha2 = "2023-08-15";
			String fecha3 = "2023-07-03";

			//Parseo String en un objeto Date
			Date fechaUno = formatoFecha.parse(fecha1);
			Date fechaDos = formatoFecha.parse(fecha2);
			Date fechaTres = formatoFecha.parse(fecha3);

			// Crear instancias de Pedido
			Pedido pedido1 = Pedido.builder()
					.estadoPedido(EstadoPedido.Iniciado)
					.fecha(fechaUno)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(5955.50)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estadoPedido(EstadoPedido.Preparado)
					.fecha(fechaDos)
					.tipoEnvio(TipoEnvio.Retiro)
					.total(7854.60)
					.build();

			Pedido pedido3 = Pedido.builder()
					.estadoPedido(EstadoPedido.Entregado)
					.fecha(fechaTres)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(8703.75)
					.build();

			// Agregar pedidos a los clientes
			cliente1.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);
			cliente2.agregarPedido(pedido3);

			// Guardar los pedidos en la base de datos
			pedidoRepositorio.save(pedido1);
			pedidoRepositorio.save(pedido2);
			pedidoRepositorio.save(pedido3);

			// Crear instancias de Factura
			Factura factura1 = Factura.builder()
					.numero(1)
					.fecha(fechaUno)
					.descuento(0)
					.formaPago(FormaPago.Efectivo)
					.total(5955)
					.build();

			Factura factura2 = Factura.builder()
					.numero(2)
					.fecha(fechaDos)
					.descuento(0)
					.formaPago(FormaPago.Credito)
					.total(7854)
					.build();

			Factura factura3 = Factura.builder()
					.numero(3)
					.fecha(fechaTres)
					.descuento(0)
					.formaPago(FormaPago.Debito)
					.total(8703)
					.build();

			// Agregar factura a pedido
			pedido1.agregarFactura(factura1);
			pedido2.agregarFactura(factura2);
			//pedido3.agregarFactura(factura3); Lo comento para probar si no tiene asociada factura.

			// Guardar las facturas en la base de datos
			facturaRepositorio.save(factura1);
			facturaRepositorio.save(factura2);
			facturaRepositorio.save(factura3);

			// Crear instancias de DetallePedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(4000)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(7000)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(8000)
					.build();

			DetallePedido detallePedido4 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1000)
					.build();

			// Agregar DetallePedido a pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido4);
			pedido2.agregarDetallePedido(detallePedido2);
			pedido3.agregarDetallePedido(detallePedido3);

			// Guardar los DetallesPedidos en la base de datos
			detallePedidoRepositorio.save(detallePedido1);
			detallePedidoRepositorio.save(detallePedido2);
			detallePedidoRepositorio.save(detallePedido3);
			detallePedidoRepositorio.save(detallePedido4);

			// Crear instancias de Productos
			Producto producto1 = Producto.builder()
					.tipoProducto(TipoProducto.Insumo)
					.tiempoEstimadoCocina(2)
					.denominacion("Ropa")
					.precioVenta(4000)
					.precioCompra(3000)
					.stockActual(5)
					.stockMinimo(2)
					.unidadMedida("")
					.receta("")
					.build();

			Producto producto2 = Producto.builder()
					.tipoProducto(TipoProducto.Manufacturado)
					.tiempoEstimadoCocina(3)
					.denominacion("Electrodoméstico")
					.precioVenta(5000)
					.precioCompra(3500)
					.stockActual(6)
					.stockMinimo(3)
					.unidadMedida("")
					.receta("")
					.build();

			Producto producto3 = Producto.builder()
					.tipoProducto(TipoProducto.Insumo)
					.tiempoEstimadoCocina(4)
					.denominacion("Electrodoméstico")
					.precioVenta(7000)
					.precioCompra(4500)
					.stockActual(8)
					.stockMinimo(4)
					.unidadMedida("")
					.receta("")
					.build();

			// Agregar Producto a DetallePedido
			detallePedido1.agregarProducto(producto1);
			detallePedido2.agregarProducto(producto2);
			detallePedido3.agregarProducto(producto3);

			// Guardar los productos en la base de datos
			productoRepositorio.save(producto1);
			productoRepositorio.save(producto2);
			productoRepositorio.save(producto3);

			// Crear instancias de Rubros
			Rubro rubro1 = Rubro.builder()
					.denominacion("Ropa")
					.build();

			Rubro rubro2 = Rubro.builder()
					.denominacion("Electrodoméstico")
					.build();

			// Agregar Producto a Rubro
			rubro1.agregarProducto(producto1);
			rubro2.agregarProducto(producto2);
			rubro2.agregarProducto(producto3);

			// Guardar los rubros en la base de datos
			rubroRepositorio.save(rubro1);
			rubroRepositorio.save(rubro2);

			//-----------------------------------------------------------------------------------
			//Uso de Métodos

			// Mostrar domicilios de clientes
			cliente1.mostrarDomicilios();
			cliente2.mostrarDomicilios();

			// Mostrar pedidos de clientes
			cliente1.mostrarPedidos();
			cliente2.mostrarPedidos();

			// Mostrar factura de pedido
			pedido1.mostrarFactura();
			pedido2.mostrarFactura();
			pedido3.mostrarFactura();

			// Mostrar DetallePedido de pedido
			pedido1.mostrarDetallePedido();
			pedido2.mostrarDetallePedido();
			pedido3.mostrarDetallePedido();

			// Mostrar Productos de rubro
			rubro1.mostrarProductos();
			rubro2.mostrarProductos();


		};

	}
}
