package com.design_pattern.bridge.model.abstraction;

import com.design_pattern.bridge.model.implementation.ReportFormmater;

public class SummaryReport extends Report{

    public SummaryReport(ReportFormmater printerReport) {
        super(printerReport);
    }

    public SummaryReport() {
    }

    @Override
    public String generateReport(String title, String data) {
        return this.getPrinterReport().generate(title+"(SUMMARY)", data);
    }
}
