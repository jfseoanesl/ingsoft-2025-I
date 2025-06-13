package com.design_pattern.bridge.model;

public class DetailHTMLReport implements Report {
    @Override
    public String generate(String data) {
        return "Generando reporte DETALLE en HTML con datos: " + data;
    }
}
