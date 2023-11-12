package com.thomasaleknovic.worshipteamorganizer.controllers;

import com.thomasaleknovic.worshipteamorganizer.dtos.EventDTO;
import com.thomasaleknovic.worshipteamorganizer.dtos.PersonDTO;
import com.thomasaleknovic.worshipteamorganizer.models.Event;
import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public ResponseEntity<List<Event>> listAllEvents (){
        return ResponseEntity.ok(eventService.findAllEvent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Event>> findEventById (@PathVariable UUID id) {
        return ResponseEntity.ok(eventService.findEventById(id));
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Event>> listAllEventsByPersonId (@PathVariable UUID id) {
        return ResponseEntity.ok(eventService.findEventsByPersonId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent (@RequestBody EventDTO data) {
        return ResponseEntity.ok(eventService.createEvent(data));
    }

    @PutMapping("/{eventId}/add-member")
    public ResponseEntity<Event> addMemberToEvent (@PathVariable UUID eventId, @RequestBody UUID personId) throws Exception {

        return ResponseEntity.ok(eventService.addMemberByPersonId(eventId, personId));
    }
 }
