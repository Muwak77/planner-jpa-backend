package de.profect.plannerjpabackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class CalendarReply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dateTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    private CalendarUser user;

    private ReplyAnswer reply;

    private String comment;

    // Default constructor for Hibernate
    protected CalendarReply() {
    }

    public ReplyAnswer getReply() {
        return reply;
    }

    public void setReply(ReplyAnswer reply) {
        this.reply = reply;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public CalendarReply(Long id, CalendarUser user, ReplyAnswer reply, String comment) {
        this.id = id;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalendarUser getUser() {
        return user;
    }

    public void setUser(CalendarUser user) {
        this.user = user;
    }

}