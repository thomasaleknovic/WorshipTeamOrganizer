package com.thomasaleknovic.worshipteamorganizer.controllers;

import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable UUID id) {
        return ResponseEntity.ok(personService.findPersonById(id));
    }

    @PostMapping("/new/person")
    public ResponseEntity<Person> createPerson (@RequestBody Person person ) {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @PutMapping("/update/person/{id}")
    public ResponseEntity<Person> updatePerson (@PathVariable UUID id, @RequestBody Person updatedPersonInfo) {
        Person personToUpdate = personService.getPersonById(id);
        return ResponseEntity.ok(personService.updatePerson(personToUpdate, updatedPersonInfo))
    }
}
