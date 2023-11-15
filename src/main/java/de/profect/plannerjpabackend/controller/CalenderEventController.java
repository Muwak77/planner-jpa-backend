package de.profect.plannerjpabackend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.profect.plannerjpabackend.model.CalendarEvent;
import de.profect.plannerjpabackend.model.CalendarReply;
import de.profect.plannerjpabackend.model.CalendarUser;
import de.profect.plannerjpabackend.repository.CalendarEventRepository;
import de.profect.plannerjpabackend.repository.CalendarUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/events/")
public class CalenderEventController {
    private CalendarEventRepository eventRepository;
    private CalendarUserRepository userRepository;

    @Autowired
    public CalenderEventController(CalendarUserRepository ur, CalendarEventRepository er) {
        this.eventRepository = er;
        this.userRepository = ur;
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public void update(@RequestBody CalendarEvent updateEvent, @PathVariable Long id) {

        //get event from the Database
        System.out.println("-----------------------------------------");
        System.out.println(updateEvent.getId());
        System.out.println(updateEvent.getName());
        System.out.println(updateEvent.getReplies().length);



        // Now you can print or log the raw request body as needed

        if (eventRepository.existsById(id)) {

            //Get the Current Event
            CalendarEvent currentEventVersion = eventRepository.getById(id);


            //Clear existing Replies
            currentEventVersion.setReplies(new CalendarReply[0]);

            System.out.println(currentEventVersion.getId());
            System.out.println("New Count:" + currentEventVersion.getReplies().length);
            for (CalendarReply reply : updateEvent.getReplies()) {

                Optional<CalendarUser> u = userRepository.findById(reply.getUser().getId());

                if (u.isPresent()) {
                    //User already exists
                    reply.setUser(u.get());
                }

                System.out.println("Reply-ID:" + reply.getId());
                System.out.println("Reply-User-ID:" + reply.getUser().getId());
                System.out.println("Reply-User-Name:" + reply.getUser().getName());
                System.out.println("Reply-Answer:" + reply.getReply());


            }
            eventRepository.save(updateEvent);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Request Body: ");
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        }
    }


}
