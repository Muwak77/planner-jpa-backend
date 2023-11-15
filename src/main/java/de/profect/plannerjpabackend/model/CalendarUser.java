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

    private String name;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean admin;

    private String password;

    // Default constructor for Hibernate
    protected CalendarUser() {
    }

    public CalendarUser(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public void setName(String username) {
        this.name = username;
    }
}