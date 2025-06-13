package com.design_pattern.bridge.model.abstraction;

import com.design_pattern.bridge.model.implementation.ReportFormmater;

public class DetailReport extends Report{

    public DetailReport(ReportFormmater printerReport) {
        super(printerReport);
    }

    public DetailReport() {
    }

    @Override
    public String generateReport(String title, String data) {
        return this.getPrinterReport().generate(title+"(DETAILS)", data);
    }
}
