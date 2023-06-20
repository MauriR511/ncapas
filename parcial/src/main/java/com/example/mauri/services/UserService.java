package com.example.mauri.services;

import com.example.mauri.models.dtos.GetUserDTO;
import com.example.mauri.models.dtos.SaveUserDTO;
import com.example.mauri.models.entities.User;

import java.util.List;

public interface UserService {
    void save(SaveUserDTO user) throws Exception;
    void deleteByUsernameOrEmail(String value) throws Exception;
    void deleteById(String id) throws Exception;
    GetUserDTO findOneByUsernameOrEmail(String value);
    User findByUsernameOrEmail(String value);
    String findUUIDByUsernameOrEmail(String username);
    List<User> findAll();
    void updatePassword(String password, String id);
    void updateUsername(String username);
    void updateEmail(String email);
}
