package ua.pp.lazin.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Thought implements Comparable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1024)
    private String text;

    private Date pubDate;

    @ManyToOne
    private User author;

    public Thought() {
    }

    public Thought(String text, User author) {
        this.text = text;
        this.author = author;
        this.pubDate = new Date();
    }

    public Thought(String text, Date pubDate, User author) {
        this.text = text;
        this.pubDate = pubDate;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public Date getPubDate() {
        return pubDate;
    }

    @Override
    public String toString() {
        return "Thought {" + text + "}";
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Thought) {
            Thought that = (Thought) o;
            return that.pubDate.compareTo(this.pubDate);
        } else {
            throw new IllegalArgumentException("Incomparable types");
        }
    }
}
