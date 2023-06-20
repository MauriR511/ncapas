package com.example.api.repositories;

import com.example.api.models.entities.Tier;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface TierRepository
    extends ListCrudRepository<Tier, UUID> {
}
