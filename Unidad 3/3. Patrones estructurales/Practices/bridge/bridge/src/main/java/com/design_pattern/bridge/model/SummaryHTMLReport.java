package com.design_pattern.bridge.model;

public class SummaryHTMLReport implements Report {
    @Override
    public String generate(String data) {
        return "Generando reporte RESUMEN en HTML con datos: " + data;
    }
}
