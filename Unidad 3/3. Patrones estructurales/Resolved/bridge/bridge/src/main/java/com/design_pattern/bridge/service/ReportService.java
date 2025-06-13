package com.design_pattern.bridge.service;

import com.design_pattern.bridge.model.*;
import com.design_pattern.bridge.model.abstraction.DetailReport;
import com.design_pattern.bridge.model.abstraction.Report;
import com.design_pattern.bridge.model.abstraction.SummaryReport;
import com.design_pattern.bridge.model.implementation.HTMLReportFormater;
import com.design_pattern.bridge.model.implementation.PDFReportFormater;
import com.design_pattern.bridge.model.implementation.ReportFormmater;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReportService {

   private Map<ReportType, Report> reports = new HashMap();
   private Map<ReportFormat, ReportFormmater> formats = new HashMap();

    public ReportService() {

        this.reports.put(ReportType.DETAIL, new DetailReport());
        this.reports.put(ReportType.SUMMARY, new SummaryReport());

        this.formats.put(ReportFormat.PDF, new PDFReportFormater());
        this.formats.put(ReportFormat.HTML, new HTMLReportFormater());

    }

    public String generateReport(ReportType type, ReportFormat format, String title, String data) {

        ReportFormmater formater = this.formats.get(format);
        Report report = this.reports.get(type);
        report.setPrinterReport(formater);
        return report.generateReport(title,data);

    }
}
