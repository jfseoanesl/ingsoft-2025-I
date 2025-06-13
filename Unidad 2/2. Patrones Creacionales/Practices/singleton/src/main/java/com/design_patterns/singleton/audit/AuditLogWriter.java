package com.design_patterns.singleton.audit;

import java.time.LocalDateTime;

public class AuditLogWriter {

    public static int CONTADOR = 0;


    public AuditLogWriter(){
        CONTADOR++;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().toString();
        System.out.println("[AUDIT] " + timestamp + " - " + message);
    }
}
