package com.design_patterns.abstract_factory.abstractFactory;

import com.design_patterns.abstract_factory.domain.*;

public class JSONReportFactory implements ReportFactory{
    @Override
    public Header createHeader() {
        return new JsonHeader();
    }

    @Override
    public Body createBody() {
        return new JsonBody();
    }

    @Override
    public Footer createFooter() {
        return new JsonFooter();
    }
}
