package com.design_pattern.bridge.model.abstraction;

import com.design_pattern.bridge.model.implementation.ReportFormmater;

public abstract class Report {

    private ReportFormmater printerReport;

    public Report(ReportFormmater printerReport){
        this.printerReport = printerReport;
    }

    public Report() {
    }

    public ReportFormmater getPrinterReport() {
        return printerReport;
    }

    public void setPrinterReport(ReportFormmater printerReport) {
        this.printerReport = printerReport;
    }

    public abstract String generateReport(String title, String data);

}
