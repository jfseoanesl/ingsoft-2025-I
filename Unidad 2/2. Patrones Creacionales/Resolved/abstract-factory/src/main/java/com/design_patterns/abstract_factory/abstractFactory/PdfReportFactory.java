package com.design_patterns.abstract_factory.abstractFactory;

import com.design_patterns.abstract_factory.domain.*;

public class PdfReportFactory implements ReportFactory {
    @Override
    public Header createHeader() {
        return new PdfHeader();
    }

    @Override
    public Body createBody() {
        return new PdfBody();
    }

    @Override
    public Footer createFooter() {
        return new PdfFooter();
    }
}
