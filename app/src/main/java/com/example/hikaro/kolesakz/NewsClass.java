package com.example.hikaro.kolesakz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hikaro on 28.05.2016.
 */
public class NewsClass {
    private String title;
    private Date date;
    private String description;
    private String source;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateFormatted=dateFormat.format(date);
        return "<p><b>"+title + "</b></p>"+'\n' +
                "<p>"+dateFormatted + "</p>"+'\n' +
                description + '\n' +
                "<p>Источник: " + source+"</p>";
    }
}
