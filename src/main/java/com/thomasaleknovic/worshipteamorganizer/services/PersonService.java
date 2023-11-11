package com.thomasaleknovic.worshipteamorganizer.services;

import com.thomasaleknovic.worshipteamorganizer.dtos.PersonDTO;
import com.thomasaleknovic.worshipteamorganizer.models.Person;
import com.thomasaleknovic.worshipteamorganizer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public Person createPerson (PersonDTO data) {

        Person person = new Person(data);
        return personRepository.save(person);
    }

    public List<Person> findAllPerson () {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonById (UUID id) {
        return personRepository.findById(id);
    }

    public Person updatePerson (Person personToUpdate, PersonDTO updatedInfo) {

        personToUpdate.setFirstName(updatedInfo.firstName());
        personToUpdate.setLastName(updatedInfo.lastName());
        personToUpdate.setIsAdmin(updatedInfo.isAdmin());
        personToUpdate.setBandRole(updatedInfo.bandRole());

        return personRepository.save(personToUpdate);

    }



}
