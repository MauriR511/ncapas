package com.example.api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "qr")
public class QR {

    @Id
    @Column(name = "QR_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String QR_id;

    @Column(name = "creation_date")
    private Timestamp creationDate;

    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    @Column(name = "exchange_date")
    private Timestamp exchangeDate;

    public QR(Timestamp creationDate, Timestamp expirationDate, Timestamp exchangeDate) {
        super();
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.exchangeDate = exchangeDate;
    }
}