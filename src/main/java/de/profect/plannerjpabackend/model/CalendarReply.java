package de.profect.plannerjpabackend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class CalendarReply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate datum;

    @ManyToOne(cascade = CascadeType.MERGE)
    private CalendarUser user;

    private ReplyAnswer answer;

    private String comment;

    // Default constructor for Hibernate
    protected CalendarReply() {
    }

    public CalendarReply(Long id, CalendarUser user, ReplyAnswer answer, String comment) {
        this.id = id;
        this.user = user;
        this.answer = answer;
        this.comment = comment;
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

    public ReplyAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(ReplyAnswer answer) {
        this.answer = answer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // You can add other methods as needed
}