package com.design_patterns.abstract_factory.service;

import com.design_patterns.abstract_factory.abstractFactory.ReportFactory;
import com.design_patterns.abstract_factory.domain.*;
import com.design_patterns.abstract_factory.factoryMethod.ConfigFactoryProvider;
import com.design_patterns.abstract_factory.factoryMethod.FactoryProvider;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private FactoryProvider provider;


    public String generateReport(FormatType format) {
        Header header;
        Body body;
        Footer footer;

        ConfigFactoryProvider config = new ConfigFactoryProvider();
        this.provider = config.getFactoryProvider(format);

        ReportFactory factory = this.provider.getFactory();
        header = factory.createHeader();
        body = factory.createBody();
        footer = factory.createFooter();


        return header.getContent() + "\n" + body.getContent() + "\n" + footer.getContent();
    }
}
