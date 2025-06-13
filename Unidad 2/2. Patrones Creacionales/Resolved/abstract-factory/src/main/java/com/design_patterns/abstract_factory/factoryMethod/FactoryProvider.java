package com.design_patterns.abstract_factory.factoryMethod;

import com.design_patterns.abstract_factory.abstractFactory.ReportFactory;

public abstract class FactoryProvider {

    public ReportFactory getFactory(){
        return this.createFactory();
    }

    public abstract ReportFactory createFactory();


}
