package com.example.mauri.controllers;

import com.example.mauri.models.dtos.MessageDTO;
import com.example.mauri.models.dtos.SavePlaylistDTO;
import com.example.mauri.models.dtos.SaveUserDTO;
import com.example.mauri.models.entities.User;
import com.example.mauri.services.PlaylistService;
import com.example.mauri.services.UserService;
import com.example.mauri.utils.RequestErrorHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private RequestErrorHandler errorHandler;

    @Autowired
    private UserService userService;

    @PostMapping("playlist")
    public ResponseEntity<?> register(@ModelAttribute @Valid SavePlaylistDTO playlist, BindingResult validations) {
        if (validations.hasErrors()) {
            return new ResponseEntity<>(
                    errorHandler.mapErrors(validations.getFieldErrors()),
                    HttpStatus.BAD_REQUEST
            );
        }

        User user = userService.findByUsernameOrEmail(playlist.getUserCode());

        if (user == null) {
            return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.BAD_REQUEST);
        } else {
            try {
                playlistService.save(playlist, user);
                return new ResponseEntity<>(new MessageDTO("Playlist created"), HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
