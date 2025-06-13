package com.design_pattern.bridge.service;

import com.design_pattern.bridge.model.*;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private Report report;

    public String generateReport(String type, String format, String data) {

        if ("SUMMARY".equalsIgnoreCase(type) && "PDF".equalsIgnoreCase(format)) {
            report = new SummaryPDFReport();
        } else if ("SUMMARY".equalsIgnoreCase(type) && "HTML".equalsIgnoreCase(format)) {
            report = new SummaryHTMLReport();
        } else if ("DETAIL".equalsIgnoreCase(type) && "PDF".equalsIgnoreCase(format)) {
            report = new DetailPDFReport();
        } else if ("DETAIL".equalsIgnoreCase(type) && "HTML".equalsIgnoreCase(format)) {
            report = new DetailHTMLReport();
        } else {
            throw new IllegalArgumentException("Combinación inválida");
        }

        return report.generate(data);
    }
}
