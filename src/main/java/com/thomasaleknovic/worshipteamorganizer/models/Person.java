package com.thomasaleknovic.worshipteamorganizer.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    public Person(String firstName, String lastName, String bandRole, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bandRole = bandRole;
        this.isAdmin = isAdmin;
    }
}
