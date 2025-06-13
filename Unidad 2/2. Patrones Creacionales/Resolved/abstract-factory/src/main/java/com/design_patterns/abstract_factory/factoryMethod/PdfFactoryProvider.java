package com.design_patterns.abstract_factory.factoryMethod;

import com.design_patterns.abstract_factory.abstractFactory.PdfReportFactory;
import com.design_patterns.abstract_factory.abstractFactory.ReportFactory;

public class PdfFactoryProvider extends FactoryProvider{
    @Override
    public ReportFactory createFactory() {
        return new PdfReportFactory();
    }
}
