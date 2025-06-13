package com.design_patterns.abstract_factory.factoryMethod;

import com.design_patterns.abstract_factory.domain.FormatType;

import java.util.HashMap;
import java.util.Map;


public class ConfigFactoryProvider {

    private Map<FormatType, FactoryProvider> providers = new HashMap<>();

    public ConfigFactoryProvider() {
        this.providers.put(FormatType.PDF, new PdfFactoryProvider());
        this.providers.put(FormatType.HTML, new HtmlFactoryProvider());
        this.providers.put(FormatType.JSON, new JSONFactoryProvider());
    }

    public FactoryProvider getFactoryProvider(FormatType format){
        return this.providers.get(format);
    }
}
