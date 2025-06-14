package com.design_pattern.decorator.services;

import com.design_pattern.decorator.model.*;
import com.design_pattern.decorator.model.decorator.PdfReportDecorator;
import com.design_pattern.decorator.model.decorator.SignedReportDecorator;
import com.design_pattern.decorator.model.decorator.ZippedReportDecorator;
import org.springframework.stereotype.Service;

@Service
public class ReportService {


    public ReportGenerator generate( boolean pdf, boolean zip, boolean signed) {
        ReportGenerator generator = new SimpleReportGenerator();

        if(pdf){
            generator = new PdfReportDecorator(generator);
        }
        if(zip ){
            generator = new ZippedReportDecorator(generator);
        }
        if(signed){
            generator = new SignedReportDecorator(generator);
        }
        return generator;
    }
}
