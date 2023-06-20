package com.example.api.repositories;

import com.example.api.models.entities.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface UserRepository
    extends ListCrudRepository<User, UUID> {

    void deleteByEmail(String email);

    User findOneByEmail(String email);
}
