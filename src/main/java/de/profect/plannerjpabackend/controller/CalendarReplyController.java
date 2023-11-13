package de.profect.plannerjpabackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.profect.plannerjpabackend.model.CalendarEvent;
import de.profect.plannerjpabackend.model.CalendarReply;
import de.profect.plannerjpabackend.repository.CalendarEventRepository;
import de.profect.plannerjpabackend.repository.CalendarReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/replies/")
public class CalendarReplyController {
    private CalendarReplyRepository replyRepository;

    @Autowired
    public CalendarReplyController(CalendarReplyRepository r) {
        this.replyRepository = r;
    }

    @GetMapping
    public List<CalendarReply> getAll() {
        return this.replyRepository.findAll();
    }

}


