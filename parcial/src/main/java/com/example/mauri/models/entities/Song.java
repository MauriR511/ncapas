package com.example.mauri.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Song")
public class Song {

    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @Column(name = "title")
    String title;

    @Column(name = "duration")
    Integer duration;

    public Song(String title, Integer duration) {
        super();
        this.title = title;
        this.duration = duration;
    }
}
