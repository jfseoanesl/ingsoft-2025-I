package com.design_pattern.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 Problemas que se evidencian:

 | Problema              | Explicación                                                                  |
 | --------------------- | ---------------------------------------------------------------------------- |
 | Combinación explosiva | Por cada nuevo tipo de reporte o nuevo formato, debes crear nuevas clases.   |
 | 						 |	Ej: 3 tipos de reporte × 3 formatos → 9 clases. 							|
 | Acoplamiento rígido   | El `ReportService` conoce todas las combinaciones.                           |
 | Violación de OCP      | No está abierto para extensión sin modificación.                             |

 */
@SpringBootApplication
public class BridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeApplication.class, args);
	}

}
