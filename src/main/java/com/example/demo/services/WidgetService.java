package com.example.demo.services;

import com.example.demo.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a WidgetService object.
 */
@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();

    /**
     * Method to create a new Widget
     *
     * @return the new widget
     */
    public Widget createWidget(Widget w) {
        Long id = (Long) (new Date()).getTime();
        w.setId((id));
        widgets.add(w);

        return w;
    }

    /**
     * Method to create a new Widget
     *
     * @return all widgets
     */
    public List<Widget> findAllWidgets() {

        return widgets;
    }

    /**
     * Method to find a widget by ID
     *
     * @return the widget
     */
    public List<Widget> findWidgetByTopic(String topicId) {

        // return filtered list
        return widgets.stream().filter(w -> w.getTopicId().equals(topicId)).collect(Collectors.toList());
    }

    /**
     * Method to find a widget for topic
     *
     * @return the widget
     */
    public Widget findWidgetById(Long id) {
        // filter widgets
        List<Widget> res = widgets.stream().filter(w -> w.getId().equals(id)).collect(Collectors.toList());

        // return first item of the filtered list
        return res.get(0);
    }

    /**
     * Method to delete a widget
     *
     * @return 1 if operation succeeds, otherwise return 0
     */
    public int deleteWidget(Long id) {

        for (Widget w : widgets) {
            if (w.getId().equals(id)) {

                widgets.remove(w);
                return 1;
            }
        }

        return 0;
    }

    /**
     * Method to update a widget
     *
     * @return the updated widget
     */
    public Integer updateWidget(Long id, Widget widget) {

        for (Widget w : widgets) {
            if (w.getId().equals(id)) {

                w = widget;
                return 1;
            }
        }

        return 0;
    }

}