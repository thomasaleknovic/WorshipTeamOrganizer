package com.thomasaleknovic.worshipteamorganizer.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.thomasaleknovic.worshipteamorganizer.dtos.PersonDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private String bandRole;
    private Boolean isAdmin;

    @JsonIgnore
    @ManyToMany(mappedBy = "eventTeam")
    private List<Event> eventList;

    public Person(PersonDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.bandRole = data.bandRole();
        this.isAdmin = data.isAdmin();
    }
}
