package com.design_patterns.abstract_factory.domain;

public class PdfHeader implements Header {
    public String getContent() {
        return "Encabezado PDF <br>";
    }
}
