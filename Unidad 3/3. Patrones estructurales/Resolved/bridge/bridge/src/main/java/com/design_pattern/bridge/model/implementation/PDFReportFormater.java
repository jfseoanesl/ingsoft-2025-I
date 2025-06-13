package com.design_pattern.bridge.model.implementation;

public class PDFReportFormater implements ReportFormmater{
    @Override
    public String generate(String title, String body) {
        StringBuilder report = new StringBuilder();
        report.append("== Reporte en PDF ==").append("\n");
        report.append("Titulo=").append(title).append("\n");
        report.append("Data=").append(body).append("\n");
        return report.toString();
    }
}
