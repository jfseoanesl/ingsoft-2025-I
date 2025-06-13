package com.design_patterns.singleton.service;

import com.design_patterns.singleton.audit.AuditLogWriter;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public String createClient(String name) {
        // Cada vez que se ejecuta esta línea se crea una nueva instancia innecesaria
        AuditLogWriter writer = new AuditLogWriter();
        writer.log("Cliente creado: " + name);
        writer.log("TOTAL OBJETOS CREADOS: " + AuditLogWriter.CONTADOR);
        return "Cliente '" + name + "' creado correctamente.";
    }

    public String findClient(String name) {
        // Cada vez que se ejecuta esta línea se crea una nueva instancia innecesaria
        AuditLogWriter writer = new AuditLogWriter();
        writer.log("Cliente consultado: " + name);
        writer.log("TOTAL OBJETOS CREADOS: " + AuditLogWriter.CONTADOR);
        return "Cliente '" + name + "' dvuelto correctamente.";
    }
}
