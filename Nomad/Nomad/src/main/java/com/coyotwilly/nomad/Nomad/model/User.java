package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Table(name = "Users")
@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private int pin;
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
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<PastTrips> pastTrips;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<FutureTrips> futureTrips;
}
