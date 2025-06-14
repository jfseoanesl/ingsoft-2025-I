package com.design_pattern.decorator.model.decorator;

import com.design_pattern.decorator.model.ReportGenerator;

public class PdfReportDecorator extends BaseDecorator{

    public PdfReportDecorator(ReportGenerator wrapper) {
        super(wrapper);
    }

    @Override
    public String generateReport(String data) {
        return "PDF ("+this.wrapper.generateReport(data)+")";
    }
}
