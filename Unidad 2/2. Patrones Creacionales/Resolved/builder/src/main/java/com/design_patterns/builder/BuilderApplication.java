package com.design_patterns.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**

 Problemas con este enfoque:

 ❗ Constructores telescópicos:
  Múltiples sobrecargas de constructor hacen difícil saber qué parámetro corresponde a qué.

 🧠 Dificultad de lectura y mantenimiento:
 El orden de los argumentos debe recordarse o consultarse constantemente.

 🧱 Falta de extensibilidad:
 Agregar un nuevo parámetro implicaría cambiar todos los constructores.

 🔧 No flexible para construir parcialmente:
 No puedes establecer valores opcionales sin pasar por todos los anteriores.

 *
 */


@SpringBootApplication
public class BuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuilderApplication.class, args);
	}

}
