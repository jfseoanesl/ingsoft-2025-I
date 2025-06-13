package com.design_patterns.abstract_factory.factoryMethod;

import com.design_patterns.abstract_factory.abstractFactory.HtmlReportFactory;
import com.design_patterns.abstract_factory.abstractFactory.ReportFactory;

public class HtmlFactoryProvider extends FactoryProvider{
    @Override
    public ReportFactory createFactory() {
        return new HtmlReportFactory();
    }
}
