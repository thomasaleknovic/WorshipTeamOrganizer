package com.thomasaleknovic.worshipteamorganizer.repository;

import com.thomasaleknovic.worshipteamorganizer.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    List<Event> findAllByEventTeam_Id(UUID id);
}
