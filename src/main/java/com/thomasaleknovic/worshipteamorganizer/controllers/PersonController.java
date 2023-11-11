package com.thomasaleknovic.worshipteamorganizer.controllers;

import com.thomasaleknovic.worshipteamorganizer.dtos.PersonDTO;
import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable UUID id) {
        return ResponseEntity.ok(personService.findPersonById(id));
    }

    @PostMapping("/new/person")
    public ResponseEntity<Person> createPerson (@RequestBody PersonDTO info ) {
        return ResponseEntity.ok(personService.createPerson(info));
    }

    @PutMapping("/update/person/{id}")
    public ResponseEntity<Person> updatePerson (@PathVariable UUID id, @RequestBody PersonDTO updatedPersonInfo) {
        return personService.findPersonById(id)
                .map(personFound -> personService.updatePerson(personFound, updatedPersonInfo))
                .map(personUpdated -> ResponseEntity.ok().body(personUpdated))
                .orElse(ResponseEntity.notFound().build());


    }
}
