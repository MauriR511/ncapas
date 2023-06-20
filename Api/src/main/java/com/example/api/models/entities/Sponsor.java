package com.example.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sponsor")
public class Sponsor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sponsor")
    private String sponsor;

    public Sponsor(String sponsor) {
        super();
        this.sponsor = sponsor;
    }
}
