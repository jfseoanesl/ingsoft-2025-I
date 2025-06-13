package com.design_patterns.singleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 Tenemos una aplicación web con varios módulos (clientes, productos, órdenes, etc.).
 Todos los módulos deben registrar eventos importantes (por ejemplo: "usuario creó cliente",
 "producto actualizado", etc.) en un registro centralizado de auditoría,
 que se escribe en un archivo local o una base de datos.
 */

/**
 * Problemas:

 - Cada vez que se necesita registrar un evento de auditoría, se crea una nueva
   instancia de AuditLogWriter. Esto puede ocasionar:
  - Pérdida de consistencia en el formato del log.
  - Mayor uso de memoria innecesario.
  - Dificultad para modificar el comportamiento de logging en un solo lugar.
  - Problemas de sincronización si se accede desde múltiples hilos.

 */

@SpringBootApplication
public class SingletonApplication {

	public static void main(String[] args) {

		SpringApplication.run(SingletonApplication.class, args);
	}

}
