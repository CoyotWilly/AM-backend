package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Table(name = "Memories")
@Entity
@Data
@AllArgsConstructor
public class Memories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgPath;
    private String place;
    private LocalDate uploadDate;
}
