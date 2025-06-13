package com.design_patterns.singleton.audit;

import java.time.LocalDateTime;

public class AuditLogWriter {

    public static int CONTADOR = 0;

    private static AuditLogWriter instance;

    private AuditLogWriter(){
        CONTADOR++;
    }


    public static AuditLogWriter getInstance(){
        if(instance == null){
            synchronized(AuditLogWriter.class){
                if(instance==null){
                    instance = new AuditLogWriter();
                }
            }
        }

        return instance;
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().toString();
        System.out.println("[AUDIT] " + timestamp + " - " + message);
    }
}
