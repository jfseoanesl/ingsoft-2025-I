package com.design_pattern.decorator.controller;

import com.design_pattern.decorator.model.ReportGenerator;
import com.design_pattern.decorator.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/generate")
    public String generate(
            @RequestParam(defaultValue = "false") boolean pdf,
            @RequestParam(defaultValue = "false") boolean signed,
            @RequestParam(defaultValue = "false") boolean zipped

    ) {
        String data= "lorem ipsum data ... ";
        ReportGenerator generator = reportService.generate( pdf, signed, zipped);
        return generator.generateReport(data);
    }
}
