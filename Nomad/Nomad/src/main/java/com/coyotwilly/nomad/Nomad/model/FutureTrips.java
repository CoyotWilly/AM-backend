package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "UpcomingTrips")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FutureTrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private String destination;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Image imgBackground;
}
