package com.example.emailverification.controller;

import com.example.emailverification.dto.PersonDto;
import com.example.emailverification.service.PersonService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController
{
    private final PersonService personService;

    public DemoController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody PersonDto personDto){

        if(personService.registerUser(personDto))
            return "Registration successful! Verification link has been send to you email-ID";
        else
            return "Email-ID already exists";
    }

    @GetMapping("/{uuid}")
    public String verify(@PathVariable("uuid") String uuid){

        String message = personService.verify(uuid);

        return message;

    }

}
