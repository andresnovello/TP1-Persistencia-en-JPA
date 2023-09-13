# TP1-Persistencia-en-JPA
# Resumen
Este Trabajo Práctico representa un sistema de ejemplo que utiliza Java Persistence API (JPA) para gestionar una base de datos relacionales. A través de esta aplicación, he tenido la oportunidad de aprender y aplicar conceptos clave de JPA, como la creación de objetos y el mapeo de relaciones.

# 1. Creación de Objetos
He aprendido a modelar entidades utilizando clases Java. Esto incluye la creación de objetos como Cliente, Domicilio, Pedido, Factura, DetallePedido, Producto, y Rubro.

# 2. Mapeo de Relaciones
El sistema utiliza el mapeo de relaciones de JPA para establecer vínculos entre las diferentes entidades. Por ejemplo, se ha implementado la relación entre Cliente y Domicilio, Cliente y Pedido, Pedido y Factura, Pedido y DetallePedido, y DetallePedido y Producto.
He aprendido cómo definir estas relaciones y cómo se traducen en la base de datos.

# 3. Uso de Enumeraciones
En este trabajo práctico tuve que usar enumeraciones (enums) para representar información estática en el sistema, como el estado de un pedido (EstadoPedido), la forma de pago (FormaPago), el tipo de envío (TipoEnvio), y el tipo de producto (TipoProducto). 
Por lo que me ha ayudado a comprender cómo gestionar tipos de datos constantes que pueden ser mapeados a columnas de una base de datos relacional.

# Problemas y Soluciones
El problema que tuve con este trabajo práctico fue cuando declaré las relaciones. El problema en si fue el uso de cascade = CascadeType.ALL, al usar cascade me daba un error al ejecutar el código, la única solución que encontré fue quitarlo, fue lo único que solucionó el problema.
