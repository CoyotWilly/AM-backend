package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "PastTrips")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastTrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private String destination;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Image> memoriesCollection;

}
