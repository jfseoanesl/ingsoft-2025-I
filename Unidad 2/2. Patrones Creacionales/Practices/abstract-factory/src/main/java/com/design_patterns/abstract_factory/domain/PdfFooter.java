package com.design_patterns.abstract_factory.domain;

public class PdfFooter implements Footer {
    public String getContent() {
        return "Pie de página PDF<br>";
    }
}
