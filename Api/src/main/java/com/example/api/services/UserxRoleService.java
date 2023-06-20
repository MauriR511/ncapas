package com.example.api.services;

import com.example.api.models.entities.Role;
import com.example.api.models.entities.User;
import com.example.api.models.entities.UserxRole;

import java.util.List;
import java.util.UUID;

public interface UserxRoleService {
    void save(UserxRole userxRole) throws Exception;
    void deleteById(UUID id) throws Exception;
    UserxRole findOneById(UUID id);
    List<UserxRole> findAll();
    List<UserxRole> findByUser(User user);
    void updateRole(Role role, UUID id);
}
