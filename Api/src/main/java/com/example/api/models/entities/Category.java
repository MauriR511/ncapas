package com.example.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_code")
    private Event event;

    @Column(name = "category")
    private String category;

    public Category(Event event, String category) {
        super();
        this.event = event;
        this.category = category;
    }
}
