package com.design_pattern.decorator.model.decorator;

import com.design_pattern.decorator.model.ReportGenerator;

public abstract class BaseDecorator implements ReportGenerator {

    protected ReportGenerator wrapper;

    public BaseDecorator(ReportGenerator wrapper) {
        this.wrapper = wrapper;
    }

}
