package com.design_patterns.abstract_factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
⚠️ Problemas del Diseño Actual
Problema	Descripción
❌ Alto acoplamiento:
    ReportService depende de todas las implementaciones concretas (PdfHeader, HtmlBody, etc.)

🔧 Difícil mantenimiento:
	Si se agrega un nuevo formato (Markdown, JSON), se debe modificar ReportService

🔁 Violación de Open/Closed:
	La clase no está cerrada para modificación

🎯 Falta encapsulamiento de la familia de objetos:
	No se agrupan los elementos coherentes del reporte en una fábrica común
*/
@SpringBootApplication
public class AbstractFactoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(AbstractFactoryApplication.class, args);
	}

}
