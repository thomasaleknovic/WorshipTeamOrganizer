package com.thomasaleknovic.worshipteamorganizer.repository;

import com.thomasaleknovic.worshipteamorganizer.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository <Person, UUID> {
}
