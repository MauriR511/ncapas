package com.example.mauri.services;

import com.example.mauri.models.dtos.SaveUserDTO;
import com.example.mauri.models.entities.User;

import java.util.List;

public interface UserService {
    void save(SaveUserDTO user) throws Exception;
    void deleteByUsernameOrEmail(String value) throws Exception;
    void deleteById(String id) throws Exception;
    User findOneByUsernameOrEmail(String value);
    List<User> findAll();
    void updatePassword(String password, String id);
    void updateUsername(String username);
    void updateEmail(String email);
}
