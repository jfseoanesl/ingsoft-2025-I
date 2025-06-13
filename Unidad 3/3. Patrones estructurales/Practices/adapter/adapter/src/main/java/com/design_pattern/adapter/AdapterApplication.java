package com.design_pattern.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 Problemas evidentes:

 | Problema                                               | Explicación                                                                                  |
 | ------------------------------------------------------ | -------------------------------------------------------------------------------------------- |
 | **Violación de OCP (Open-Closed Principle)**           | Cada vez que integres un nuevo proveedor, debes modificar `PaymentService`.                    |
 | **Violación de DIP (Dependency Inversion Principle)**  | El `PaymentService` depende directamente de implementaciones concretas                       |
 | **Acoplamiento fuerte**                                | No puedes cambiar el proveedor sin modificar el service.                                     |

 */


@SpringBootApplication
public class AdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterApplication.class, args);
	}

}
