package com.coyotwilly.nomad.Nomad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "PastTrips")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastTrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String destination;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Memories> memoriesCollection;

}
