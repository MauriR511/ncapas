package com.example.mauri.services.implementations;

import com.example.mauri.models.dtos.SaveUserDTO;
import com.example.mauri.models.entities.User;
import com.example.mauri.repositories.UserRepository;
import com.example.mauri.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void save(SaveUserDTO user) throws Exception {
        User newUser = new User(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );

        userRepository.save(newUser);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteByUsernameOrEmail(String value) throws Exception {
        userRepository.deleteByUsernameOrEmail(value, value);

    }

    @Override
    public void deleteById(String id) throws Exception {
        UUID code = UUID.fromString(id);
        userRepository.deleteById(code);
    }

    @Override
    public User findOneByUsernameOrEmail(String value) {

        try {
            return userRepository.findOneByUsernameOrEmail(value, value);
        }
        catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void updatePassword(String password, String id) {
        User user =  userRepository.findOneByUsernameOrEmail(id, id);

        if (user != null) {
            user.setPassword(password);
            userRepository.save(user);
        }

    }

    @Override
    public void updateUsername(String username) {
        User user = userRepository.findOneByUsernameOrEmail(username, username);

        if (user != null) {
            user.setUsername(username);
            userRepository.save(user);
        }

    }

    @Override
    public void updateEmail(String email) {
        User user = userRepository.findOneByUsernameOrEmail(email, email);

        if (user != null) {
            user.setEmail(email);
            userRepository.save(user);
        }
    }
}
