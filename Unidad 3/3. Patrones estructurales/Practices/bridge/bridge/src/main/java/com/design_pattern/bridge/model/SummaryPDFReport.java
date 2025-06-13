package com.design_pattern.bridge.model;

public class SummaryPDFReport implements Report {
    @Override
    public String generate(String data) {
        return "Generando reporte RESUMEN en PDF con datos: " + data;
    }
}