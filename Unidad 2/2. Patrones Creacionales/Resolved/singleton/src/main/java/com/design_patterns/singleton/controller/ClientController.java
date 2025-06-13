package com.design_patterns.singleton.controller;

import com.design_patterns.singleton.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public String createClient(@RequestParam String name) {
        return clientService.createClient(name);
    }

    @GetMapping
    public String getClient(@RequestParam String name) {
        return clientService.findClient(name);
    }
}
