package com.design_pattern.bridge.model.implementation;

public class HTMLReportFormater implements ReportFormmater{
    @Override
    public String generate(String title, String body) {

        return "<html>" +
                    "<body>" +
                        "<h1>" + title + "</h1>" +
                        "<p>" + body + "</p>" +
                    "</body>" +
                "</html>";
    }
}
