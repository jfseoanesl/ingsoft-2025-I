package com.design_pattern.decorator.model;

public class PdfReportWithSignatureAndZipGenerator extends PdfReportWithSignatureGenerator {

    @Override
    public String generateReport(String data) {

        return "ZIP(" + super.generateReport(data) + ")";
    }
}
