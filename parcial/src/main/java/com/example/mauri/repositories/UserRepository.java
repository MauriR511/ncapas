package com.example.mauri.repositories;

import com.example.mauri.models.entities.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface UserRepository
    extends ListCrudRepository<User, UUID>{
    void deleteByUsernameOrEmail(String username, String email);
    User findOneByUsernameOrEmail(String username, String email);

    }
