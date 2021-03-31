package com.example.demo.services;

import com.example.demo.models.Widget;
import com.example.demo.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a WidgetService object.
 */
@Service
public class WidgetService {
    @Autowired
    WidgetRepository repo;

    /**
     * Method to create a new Widget
     *
     * @return the new widget
     */
    public Widget createWidget(Widget widget) {
        return repo.save(widget);
    }

    /**
     * Method to create a new Widget
     *
     * @return all widgets
     */
    public List<Widget> findAllWidgets() {

        return repo.findAllWidgets();
    }

    /**
     * Method to find a widget by ID
     *
     * @return the widget
     */
    public List<Widget> findWidgetByTopic(String topicId) {

        // return filtered list
        return repo.findWidgetByTopic(topicId);
    }

    /**
     * Method to find a widget for topic
     *
     * @return the widget
     */
    public Widget findWidgetById(Long id) {
        // return widget
        return repo.findWidgetById(id);
    }

    /**
     * Method to delete a widget
     *
     * @return 1 if operation succeeds, otherwise return 0
     */
    public int deleteWidget(Long id) {
        repo.deleteById(id);
        return 1;
    }

    /**
     * Method to update a widget
     *
     * @return the updated widget
     */
    public Integer updateWidget(Long id, Widget widget) {
        Widget originalWidget = findWidgetById(id);
        String type = originalWidget.getType();

        switch (type) {
            case "HEADING":
                originalWidget.setSize(widget.getSize());
                originalWidget.setText(widget.getText());
                break;
            case "PARAGRAPH":
                originalWidget.setText(widget.getText());
                break;
            case "IMAGE":
                originalWidget.setSrc(widget.getSrc());
                originalWidget.setWidth(widget.getWidth());
                originalWidget.setHeight(widget.getHeight());
                break;
            case "LIST":
                originalWidget.setOrdered(widget.getOrdered());
                break;
            default:
                return 0;

        }
        originalWidget.setType(widget.getType());
        repo.save(originalWidget);

        return 1;
    }

}