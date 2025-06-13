package com.design_patterns.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 ❌ Problemas de esta versión:

 - Duplicación de lógica: Todas las campañas usan los mismos canales, pero se repite el código.
 - Baja escalabilidad: Si el diseño o los canales cambian, hay que editar múltiples métodos.
 - Difícil de mantener: Aumenta el riesgo de errores al copiar/pegar estructuras similares.
 - Violación de SRP y DRY: El principio de responsabilidad única y no repetición se rompe.

 */

@SpringBootApplication
public class PrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypeApplication.class, args);
	}

}
