package com.design_pattern.bridge.controller;

import com.design_pattern.bridge.model.ReportRequest;
import com.design_pattern.bridge.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public String generateReport(@RequestBody ReportRequest request) {
        String result=reportService.generateReport(
                request.type(),
                request.format(),
                request.title(),
                request.data());
        return result;
    }
}
