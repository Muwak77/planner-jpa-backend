package de.profect.plannerjpabackend.controller;

import de.profect.plannerjpabackend.model.CalendarUser;
import de.profect.plannerjpabackend.repository.CalendarUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class CalenderUserController {
    private CalendarUserRepository userRepository;
    @Autowired
    public CalenderUserController(CalendarUserRepository r) {
        this.userRepository=r;
    }
    @GetMapping
    public List<CalendarUser> getAll() {
        List<CalendarUser> l = new ArrayList<CalendarUser>();
        //return l;



        return this.userRepository.findAll();
    }

    @PostMapping
    public CalendarUser addUser(@RequestBody CalendarUser newUser) {
        return userRepository.save(newUser);
    }
}
