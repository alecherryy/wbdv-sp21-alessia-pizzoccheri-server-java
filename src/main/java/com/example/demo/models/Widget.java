package com.example.demo.models;


/**
 * This class represents a Widget object.
 */
public class Widget {
    private Integer id;
    private String name;
    private String topicID;
    private Integer widgetOrder;
    private String type;
    private String url;
    private Integer size;
    private String text;
    private Integer width;
    private Integer height;
    private String src;
    private Boolean ordered;
    private String cssClass;
    private String style;
    private String value;

    /**
     * Class constructor.
     */
    public Widget(Integer id, String name, String topicID, Integer widgetOrder, String type, String url,
                  Integer size, String text, Integer width, Integer height, String src,
                  Boolean ordered, String cssClass, String style, String value) {
        this.id = id;
        this.name = name;
        this.topicID = topicID;
        this.widgetOrder = widgetOrder;
        this.type = type;
        this.url = url;
        this.size = size;
        this.text = text;
        this.width = width;
        this.height = height;
        this.src = src;
        this.ordered = ordered;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
    }

    /**
     * Overload class constructor.
     */
    public Widget() {}

    /**
     * Getter method.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter method.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter method.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method.
     *
     * @return the id
     */
    public String getTopicID() {
        return topicID;
    }

    /**
     * Setter method.
     */
    public void setTopicID(String topicID) {
        this.topicID = topicID;
    }

    /**
     * Getter method.
     *
     * @return the order of the widget
     */
    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    /**
     * Setter method.
     */
    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    /**
     * Getter method.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter method.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method.
     *
     * @return the size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * Setter method.
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * Getter method.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Setter method.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter method.
     *
     * @return the width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * Setter method.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * Getter method.
     *
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Setter method.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * Getter method.
     *
     * @return the source
     */
    public String getSrc() {
        return src;
    }

    /**
     * Setter method.
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * Getter method.
     *
     * @return boolean value
     */
    public Boolean getOrdered() {
        return ordered;
    }

    /**
     * Setter method.
     */
    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    /**
     * Getter method.
     *
     * @return the CSS class
     */
    public String getCssClass() {
        return cssClass;
    }

    /**
     * Setter method.
     */
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * Getter method.
     *
     * @return the style
     */
    public String getStyle() {
        return style;
    }

    /**
     * Setter method.
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * Getter method.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter method.
     */
    public void setValue(String value) {
        this.value = value;
    }
}
