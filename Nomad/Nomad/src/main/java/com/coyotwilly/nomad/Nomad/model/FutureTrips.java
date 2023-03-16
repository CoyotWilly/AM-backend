package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "UpcomingTrips")
@Entity
@Data
@AllArgsConstructor
public class FutureTrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String destination;
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<ToDoList> reminderList;
}
