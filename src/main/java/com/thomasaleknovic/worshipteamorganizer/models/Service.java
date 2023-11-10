package com.thomasaleknovic.worshipteamorganizer.models;

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
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String serviceName;
    private Date serviceDate;
    @ManyToMany
    @JoinTable(
            name = "service_team", joinColumns = @JoinColumn(
            name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<Person> serviceTeam;


    public Service(String serviceName, Date serviceDate) {
        this.serviceName = serviceName;
        this.serviceDate = serviceDate;
    }
}
