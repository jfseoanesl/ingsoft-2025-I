package com.design_patterns.abstract_factory.controller;

import com.design_patterns.abstract_factory.domain.FormatType;
import com.design_patterns.abstract_factory.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public ResponseEntity<String> generateReport(@RequestParam FormatType format) {
        String report = reportService.generateReport(format);
        return ResponseEntity.ok(report);
    }
}
