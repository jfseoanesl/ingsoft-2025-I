package com.design_pattern.decorator.model.decorator;

import com.design_pattern.decorator.model.ReportGenerator;

public class SignedReportDecorator extends BaseDecorator    {
    public SignedReportDecorator(ReportGenerator wrapper) {
        super(wrapper);
    }

    @Override
    public String generateReport(String data) {
        return this.wrapper.generateReport(data) + "[SIGNED]";
    }
}
