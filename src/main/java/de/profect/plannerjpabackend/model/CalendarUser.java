package de.profect.plannerjpabackend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.EmbeddableInstantiator;

import java.time.LocalDate;
@Entity
public class CalendarUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String username;

    // Default constructor for Hibernate
    protected CalendarUser() {
    }

    public CalendarUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}