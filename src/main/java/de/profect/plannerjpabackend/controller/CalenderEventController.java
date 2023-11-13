package de.profect.plannerjpabackend.controller;

import de.profect.plannerjpabackend.model.CalendarEvent;
import de.profect.plannerjpabackend.repository.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/events/")
public class CalenderEventController {
    private CalendarEventRepository eventRepository;
    @Autowired
    public CalenderEventController(CalendarEventRepository r) {
        this.eventRepository=r;
    }
    @GetMapping
    public List<CalendarEvent> getAll() {
        return this.eventRepository.findAll();
    }

    @PostMapping
    public CalendarEvent addEvent(@RequestBody CalendarEvent newEvent) {
        return eventRepository.save(newEvent);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public void update(@RequestBody CalendarEvent updateEvent,@PathVariable Long id) {
        System.out.println("Request Body: " + updateEvent);
        if(!eventRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not Found");
        }

        eventRepository.save(updateEvent);
    }
}
