package com.example.demo.controllers;

import com.example.demo.models.Widget;
import com.example.demo.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class represents a Widget controller
 */
@RestController
public class WidgetController {
    @Autowired
    WidgetService service;

    /**
     * Method to return all widgets
     *
     * @return all widgets
     */
    @GetMapping("/api/widgets/")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }
}
