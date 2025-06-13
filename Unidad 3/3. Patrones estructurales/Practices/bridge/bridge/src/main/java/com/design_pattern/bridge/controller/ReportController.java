package com.design_pattern.bridge.controller;

import com.design_pattern.bridge.service.ReportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/generate")
    public String generateReport(
            @RequestParam String type,
            @RequestParam String format,
            @RequestBody String data
    ) {
        String result=reportService.generateReport(type, format, data);
        return result;
    }
}
