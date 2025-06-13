package com.design_patterns.abstract_factory.domain;

public class JsonBody implements Body{
    @Override
    public String getContent() {
        return " Cuerpo en formato JSON <br>";
    }
}
