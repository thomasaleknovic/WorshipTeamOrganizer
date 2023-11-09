package com.thomasaleknovic.worshipteamorganizer.repository;

import com.thomasaleknovic.worshipteamorganizer.models.Person;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    PersonRepository personRepository;

    private Person createPerson (Person data) {
        Person newPerson = new Person(
                data.getFirstName(),
                data.getLastName(),
                data.getBandRole(),
                data.getIsAdmin()
        );
         this.entityManager.persist(newPerson);
         return newPerson;
    };

    @Test
    @DisplayName("Should return a person by it's id successfully from DB.")
    void findPersonByIdCase1() {
        Person data = new Person("Thomas", "Aleknovic", "Guitarrista", true);
        Person newPerson = this.createPerson(data);
        Optional<Person> result = this.personRepository.findById(newPerson.getId());


        assertTrue(result.isPresent());


    }

    @Test
    @DisplayName("Should not return a person by it's id from DB.")
    void findPersonByIdCase2() {

        Optional<Person> result = this.personRepository.findById(UUID.randomUUID());


        assertFalse(result.isPresent());


    }

}