package ua.pp.lazin.entity;

import java.util.Date;

public class Thought {
    private String text;
    private Date pubDate;


    public Thought(String text) {
        this.text = text;
        this.pubDate = new Date();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
