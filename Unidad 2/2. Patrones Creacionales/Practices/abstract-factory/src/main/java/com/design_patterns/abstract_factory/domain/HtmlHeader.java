package com.design_patterns.abstract_factory.domain;

public class HtmlHeader implements Header {
    public String getContent() {
        return "Encabezado HTML<br>";
    }
}
