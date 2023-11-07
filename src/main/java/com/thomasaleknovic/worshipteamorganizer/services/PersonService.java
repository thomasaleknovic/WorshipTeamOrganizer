package com.thomasaleknovic.worshipteamorganizer.services;

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


    public Person createPerson (Person person) {
       return personRepository.save(person);
    }

    public List<Person> findAllPerson () {
        return personRepository.findAll();
    }

    public Optional<Person> findPersonById (UUID id) {
        return personRepository.findById(id);
    }

    public Person updatePerson (Person personToUpdate, Person updatedInfo) {
        personToUpdate.setFirstName(updatedInfo.getFirstName());
        personToUpdate.setLastName(updatedInfo.getLastName());
        personToUpdate.setIsAdmin(updatedInfo.getIsAdmin());
        personToUpdate.setBandRole(updatedInfo.getBandRole());

        return personRepository.save(personToUpdate);

    }



}
