package com.design_pattern.decorator.model;

public class PdfReportGenerator extends SimpleReportGenerator {

    @Override
    public String generateReport(String data) {
        return "PDF(" + super.generateReport(data) + ")";
    }
}
