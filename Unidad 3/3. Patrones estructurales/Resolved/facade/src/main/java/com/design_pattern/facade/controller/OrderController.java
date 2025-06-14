package com.design_pattern.facade.controller;

import com.design_pattern.facade.facade.EcommerceFacade;
import com.design_pattern.facade.model.*;
import com.design_pattern.facade.subsystems.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private EcommerceFacade ecommerceFacade;

    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestBody OrderRequest request) {

        return ecommerceFacade.processOrder(request);

    }
}
