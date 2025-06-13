package com.design_patterns.abstract_factory.abstractFactory;

import com.design_patterns.abstract_factory.domain.*;

public class HtmlReportFactory implements ReportFactory {
    @Override
    public Header createHeader() {
        return new HtmlHeader();
    }

    @Override
    public Body createBody() {
        return new HtmlBody();
    }

    @Override
    public Footer createFooter() {
        return new HtmlFooter();
    }
}
