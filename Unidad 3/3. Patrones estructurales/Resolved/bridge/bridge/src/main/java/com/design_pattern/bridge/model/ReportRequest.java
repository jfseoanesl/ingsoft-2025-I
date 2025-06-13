package com.design_pattern.bridge.model;

public record ReportRequest(String title, String data, ReportType type, ReportFormat format) {
}
