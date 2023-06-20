package com.example.mauri.controllers;

import com.example.mauri.models.dtos.GetSongDTO;
import com.example.mauri.models.dtos.MessageDTO;
import com.example.mauri.models.dtos.SaveSongDTO;
import com.example.mauri.models.entities.Song;
import com.example.mauri.models.entities.User;
import com.example.mauri.services.SongService;
import com.example.mauri.utils.RequestErrorHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private RequestErrorHandler errorHandler;

    @PostMapping("/save")
    public ResponseEntity<?> save(@ModelAttribute @Valid SaveSongDTO song, BindingResult validations){
        if(validations.hasErrors()){
            return new ResponseEntity<>(
                    errorHandler.mapErrors(validations.getFieldErrors()),
                    HttpStatus.BAD_REQUEST
            );
        }

        try{
            songService.save(song);
            return new ResponseEntity<>(new MessageDTO("Song saved"), HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(@RequestParam("title") String title){
       System.out.println("title: " + title);
        List<GetSongDTO> songs = songService.findByTitleContaining(title);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public ResponseEntity<?> findOneByTitle(@PathVariable(name = "title") String title){
        try{
            GetSongDTO song = songService.findOneByTitle(title);

            return new ResponseEntity<>(song, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
