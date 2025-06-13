package com.design_patterns.abstract_factory.domain;

public class JsonFooter implements Footer {
    @Override
    public String getContent() {
        return "Pie de pagina en formato JSON <br>";
    }
}
