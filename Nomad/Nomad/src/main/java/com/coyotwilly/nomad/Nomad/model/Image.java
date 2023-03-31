package com.coyotwilly.nomad.Nomad.model;

import com.fasterxml.jackson.databind.ser.std.ByteArraySerializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name = "Memories")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @NonNull
    private Long userId;
    @Lob
    private byte[] content;
}
