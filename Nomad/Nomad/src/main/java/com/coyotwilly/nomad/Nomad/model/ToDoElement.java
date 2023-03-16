package com.coyotwilly.nomad.Nomad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "ToDoElement")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ToDoElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String element;
}
