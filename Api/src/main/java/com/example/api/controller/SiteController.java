package com.example.api.controller;

import com.example.api.models.entities.User;
import com.example.api.services.SiteService;
import com.example.api.utils.RequestErrorHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private SiteService siteService;

    @Autowired
    private RequestErrorHandler errorHandler;

    @PostMapping("/save")
    public ResponseEntity<?> save(@ModelAttribute @Valid User user, BindingResult validations){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patch(@PathVariable(name = "id") String id, @ModelAttribute @Valid User user, BindingResult validations){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
