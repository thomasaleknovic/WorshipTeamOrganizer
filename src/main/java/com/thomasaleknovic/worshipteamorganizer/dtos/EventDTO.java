package com.thomasaleknovic.worshipteamorganizer.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thomasaleknovic.worshipteamorganizer.models.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public record EventDTO(String eventName, Date eventDate, List<Person> eventTeam) {


}
