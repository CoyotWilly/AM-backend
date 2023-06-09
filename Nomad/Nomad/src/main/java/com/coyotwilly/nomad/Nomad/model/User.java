package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Users")
@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Integer pin;
    private String login;
    @NonNull
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    @NonNull
    private String passportNo;
    @NonNull
    private String documentNo;
    private String street;
    private String homeNo;
    private int apartmentNo;
    private String city;
    private String country;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<ActiveTrips> activeTrips;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<PastTrips> pastTrips;

    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<FutureTrips> futureTrips;
}
