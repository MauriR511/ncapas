package com.example.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "organizer")
public class Organizer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "organizer")
    private String organizer;

    public Organizer(String organizer) {
        super();
        this.organizer = organizer;
    }
}
