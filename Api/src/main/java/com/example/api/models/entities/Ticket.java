package com.example.api.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ticket_number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_code")
    private User user;

    @Column(name = "purchase_date")
    private Timestamp purchaseDate;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "priority")
    private String priority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qr_code")
    private QR qr;

    public Ticket(User user, Timestamp purchaseDate, Boolean isValid, String priority, QR qr) {
        super();
        this.user = user;
        this.purchaseDate = purchaseDate;
        this.isValid = isValid;
        this.priority = priority;
        this.qr = qr;
    }
}
