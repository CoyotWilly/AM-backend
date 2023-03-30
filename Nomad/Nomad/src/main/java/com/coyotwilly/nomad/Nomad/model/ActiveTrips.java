package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "active_trips")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveTrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private String destination;

    @OneToOne
    private Image imgBackground;
}
