package de.profect.plannerjpabackend.controller;

import de.profect.plannerjpabackend.model.CalendarEvent;
import de.profect.plannerjpabackend.model.CalendarReply;
import de.profect.plannerjpabackend.model.CalendarUser;
import de.profect.plannerjpabackend.repository.CalendarUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users/")
public class CalenderUserController {
    private CalendarUserRepository userRepository;

    @Autowired
    public CalenderUserController(CalendarUserRepository r) {
        this.userRepository = r;
    }

    @GetMapping
    public List<CalendarUser> getAll() {
        if(this.userRepository.count()<=0) {
            CalendarUser initalUser=new CalendarUser(1L,"admin",true,"1234");
            this.userRepository.save(initalUser);
        }
        return this.userRepository.findAll();
    }

    @PostMapping
    public CalendarUser addUser(@RequestBody CalendarUser newUser) {
        return userRepository.save(newUser);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/{id}")
    public void update(@RequestBody CalendarUser updateUser, @PathVariable Long id) {

        if (userRepository.existsById(id)) {
            userRepository.save(updateUser);
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        System.out.println("Request Body: ");
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }



}
