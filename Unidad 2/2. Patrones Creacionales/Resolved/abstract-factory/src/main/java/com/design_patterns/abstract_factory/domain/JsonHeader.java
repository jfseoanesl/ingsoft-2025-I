package com.design_patterns.abstract_factory.domain;

public class JsonHeader implements Header {
    @Override
    public String getContent() {
        return " Encabezado en formato JSON";
    }
}
