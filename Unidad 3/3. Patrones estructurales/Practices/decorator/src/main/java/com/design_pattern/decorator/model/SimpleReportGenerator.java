package com.design_pattern.decorator.model;

public class SimpleReportGenerator implements ReportGenerator {

    @Override
    public String generateReport(String data) {
        return "Basic Report Content[ "+data+" ]";
    }
}
