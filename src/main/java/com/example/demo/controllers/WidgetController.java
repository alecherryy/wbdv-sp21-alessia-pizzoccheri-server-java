package com.example.demo.controllers;

import com.example.demo.models.Widget;
import com.example.demo.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class represents a Widget controller
 */
@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;

    /**
     * Method to create new widget
     *
     * @return the new widget
     */
    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(@PathVariable("tid") String tid, Widget w) {
        return service.createWidget(w);
    }

    /**
     * Method to return all widgets
     *
     * @return all widgets
     */
    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    /**
     * Method to return all widgets
     *
     * @return all widgets
     */
    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetByTopic(@PathVariable("tid") String tid) {
        return service.findWidgetByTopic(tid);
    }

    /**
     * Method to find widget by its ID
     *
     * @return the widget
     */
    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Long wid) {
        return service.findWidgetById(wid);
    }

    /**
     * Method to delete a widget
     *
     * @return 1 if operation succeeds, otherwise return 0
     */
    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(@PathVariable("wid") Long wid) {
        return service.deleteWidget(wid);
    }

    /**
     * Method to update a widget
     *
     * @return the updated widget
     */
    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(@PathVariable("wid") Long wid, Widget widget) {
        return service.updateWidget(wid, widget);
    }
}
