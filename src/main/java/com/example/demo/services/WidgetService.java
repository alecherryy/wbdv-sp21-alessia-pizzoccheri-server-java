package com.example.demo.services;

import com.example.demo.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a WidgetService object.
 */
@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();

    {
        Widget w1 = new Widget(123l, "Widget 1", "604691acb2d531001729e262", 1,
                "HEADING", "#", 1, "", 0, 0,
                "source", true, "Widget Title", "", "Some value");
        Widget w2 = new Widget(234l, "Widget 2", "604691acb2d531001729e262", 2,
                "HEADING", "#", 2, "This is a subtitle", 0, 0,
                "source", true, "", "", "Some value");
        widgets.add(w1);
        widgets.add(w2);
    }

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
        return (ArrayList<Widget>) widgets.stream().filter(w -> w.getTopicId().equals(topicId));
    }

    /**
     * Method to find a widget for topic
     *
     * @return the widget
     */
    public Widget findWidgetById(Long id) {
        // filter widgets
        ArrayList<Widget> res = (ArrayList<Widget>) widgets.stream().filter(w -> w.getId().equals(id));

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
    public Widget updateWidget(Long id, Widget widget) {

        for (Widget w : widgets) {
            if (widget.getId().equals(id)) {

                w = widget;
                return w;
            }
        }

        return null;
    }

}