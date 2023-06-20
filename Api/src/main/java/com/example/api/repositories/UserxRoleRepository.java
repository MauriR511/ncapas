package com.example.api.repositories;

import com.example.api.models.entities.UserxRole;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface UserxRoleRepository
        extends ListCrudRepository<UserxRole, UUID> {
}
