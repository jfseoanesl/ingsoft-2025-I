package com.design_pattern.decorator.model.decorator;

import com.design_pattern.decorator.model.ReportGenerator;

public class ZippedReportDecorator extends BaseDecorator{

    public ZippedReportDecorator(ReportGenerator wrapper) {
        super(wrapper);
    }

    @Override
    public String generateReport(String data) {
        return "ZIP (" + wrapper.generateReport(data) + ")";
    }
}
