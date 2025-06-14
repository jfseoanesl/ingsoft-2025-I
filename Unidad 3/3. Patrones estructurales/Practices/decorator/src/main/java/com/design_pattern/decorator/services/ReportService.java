package com.design_pattern.decorator.services;

import com.design_pattern.decorator.model.PdfReportGenerator;
import com.design_pattern.decorator.model.PdfReportWithSignatureAndZipGenerator;
import com.design_pattern.decorator.model.*;
import org.springframework.stereotype.Service;

@Service
public class ReportService {


    public ReportGenerator generate( boolean pdf, boolean zip, boolean signed) {
        ReportGenerator generator;

        if(pdf && !zip && !signed){
            generator = new PdfReportGenerator();
        }
        else if(pdf && zip && !signed){
            generator = new PdfReportWithSignatureGenerator();
        }
        else if(pdf && zip && signed){
            generator = new PdfReportWithSignatureAndZipGenerator();
        }else{
            generator = new SimpleReportGenerator();
        }

        return generator;
    }
}
