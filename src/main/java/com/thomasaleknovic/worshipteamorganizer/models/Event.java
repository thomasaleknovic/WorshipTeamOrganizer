package com.thomasaleknovic.worshipteamorganizer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.thomasaleknovic.worshipteamorganizer.dtos.EventDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String eventName;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date eventDate;

    @ManyToMany
    @JoinTable(
            name = "event_team", joinColumns = @JoinColumn(
            name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> eventTeam;


    public Event(EventDTO data) {
        this.eventName = data.eventName();
        this.eventDate = data.eventDate();
    }
}
