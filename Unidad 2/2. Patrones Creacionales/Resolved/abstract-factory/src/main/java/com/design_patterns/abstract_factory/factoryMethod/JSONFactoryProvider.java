package com.design_patterns.abstract_factory.factoryMethod;

import com.design_patterns.abstract_factory.abstractFactory.JSONReportFactory;
import com.design_patterns.abstract_factory.abstractFactory.ReportFactory;

public class JSONFactoryProvider extends FactoryProvider{
    @Override
    public ReportFactory createFactory() {
        return new JSONReportFactory();
    }
}
