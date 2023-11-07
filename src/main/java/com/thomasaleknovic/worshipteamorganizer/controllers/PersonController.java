package com.thomasaleknovic.worshipteamorganizer.controllers;

import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> listAllPerson () {
        return ResponseEntity.ok(personService.findAllPerson());
    }
}
