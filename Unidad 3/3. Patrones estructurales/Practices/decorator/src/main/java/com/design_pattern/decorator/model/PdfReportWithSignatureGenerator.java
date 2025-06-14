package com.design_pattern.decorator.model;

public class PdfReportWithSignatureGenerator extends PdfReportGenerator {

    @Override
    public String generateReport(String data) {

        return super.generateReport(data) + " [Signed]";
    }
}
