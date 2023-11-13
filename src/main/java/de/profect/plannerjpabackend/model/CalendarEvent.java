package de.profect.plannerjpabackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CalendarEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate datum;
    @OneToMany(cascade = CascadeType.MERGE)
    private CalendarReply[] replies;

    // Default constructor for Hibernate
    protected CalendarEvent() {
    }

    public CalendarEvent(Long id, String name, LocalDate datum, CalendarReply[] replies) {
        this.id = id;
        this.name = name;
        this.datum = datum;
        this.replies = replies;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public CalendarReply[] getReplies() {
        return replies;
    }

    public void setReplies(CalendarReply[] replies) {
        this.replies = replies;
    }

    // You can add other methods as needed
}