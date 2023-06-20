package com.example.api.repositories;

import com.example.api.models.entities.Ticket;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface TicketRepository
    extends ListCrudRepository<Ticket, UUID> {
}
