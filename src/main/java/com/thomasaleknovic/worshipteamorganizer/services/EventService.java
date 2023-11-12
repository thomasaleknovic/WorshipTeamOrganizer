package com.thomasaleknovic.worshipteamorganizer.services;

import com.thomasaleknovic.worshipteamorganizer.dtos.EventDTO;
import com.thomasaleknovic.worshipteamorganizer.models.Event;
import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.repository.EventRepository;
import com.thomasaleknovic.worshipteamorganizer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PersonRepository personRepository;


    public Event createEvent (EventDTO data) {

        Event event = new Event(data);
        return eventRepository.save(event);

    }

    public List<Event> findAllEvent() {
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(UUID id) {
        return eventRepository.findById(id);
    }


    public List<Event> findEventsByPersonId (UUID id) {
        return eventRepository.findAllByEventTeam_Id(id);
    }

    public Event updateEventInfo (Event eventToUpdate, EventDTO infoToUpdate) {

        eventToUpdate.setEventName(infoToUpdate.eventName());
        eventToUpdate.setEventDate(infoToUpdate.eventDate());

        return eventRepository.save(eventToUpdate);
    }


    //Add team member

    public Event addMemberByPersonId (UUID eventId, UUID personId) throws Exception {

         Optional<Event> eventFound = eventRepository.findById(eventId);

         Optional<Person> personFound = personRepository.findById(personId);

            if(personFound.isPresent() && eventFound.isPresent()) {
                eventFound.get().getEventTeam().add(personFound.get());
                personFound.get().getEventList().add(eventFound.get());
                personRepository.save(personFound.get());
                return eventRepository.save(eventFound.get());

            } else {
                throw new Exception();
            }



    }

    //Remove team member


    //Add music


    //Remove music

}
