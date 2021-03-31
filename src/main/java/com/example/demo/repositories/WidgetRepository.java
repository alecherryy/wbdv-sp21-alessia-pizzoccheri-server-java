package com.example.demo.repositories;

import com.example.demo.models.Widget;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface represents a Widget Repository and extends
 * the CrudRepository object from Java library
 */
public interface WidgetRepository extends CrudRepository<Widget, Long> {
    /**
     * Find all widgets in the database
     * @return a list of widgets
     */
    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();

    /**
     * Find a Widget by id
     * @return the widget
     */
    @Query(value="SELECT * FROM widgets WHERE id=:wid", nativeQuery = true)
    public Widget findWidgetById(@Param("wid") Long widgetId);

    /**
     * Find a Widget whose topicId matches tid
     * @return a list of widgets
     */
    @Query(value="SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetByTopic(@Param("tid") String topicId);
}
