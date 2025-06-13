package com.design_pattern.bridge.model;

public class DetailPDFReport implements Report {
    @Override
    public String generate(String data) {
        return "Generando reporte DETALLE en PDF con datos: " + data;
    }
}
