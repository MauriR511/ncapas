package com.example.mauri.controllers;

import com.example.mauri.models.dtos.GetUserDTO;
import com.example.mauri.models.dtos.MessageDTO;
import com.example.mauri.models.dtos.SaveUserDTO;
import com.example.mauri.models.dtos.UserPatchDTO;
import com.example.mauri.models.entities.User;
import com.example.mauri.services.UserService;
import com.example.mauri.utils.RequestErrorHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RequestErrorHandler errorHandler;

    @PostMapping("auth/signup")
    public ResponseEntity<?> register(@ModelAttribute @Valid SaveUserDTO user, BindingResult validations){
        if(validations.hasErrors()){
            return new ResponseEntity<>(
              errorHandler.mapErrors(validations.getFieldErrors()),
                    HttpStatus.BAD_REQUEST
            );
        }

        GetUserDTO getUser = userService.findOneByUsernameOrEmail(user.getUsername());
        GetUserDTO getUserEmail = userService.findOneByUsernameOrEmail(user.getEmail());

        if(getUser != null){
            return new ResponseEntity<>(new MessageDTO("Username already exists"), HttpStatus.BAD_REQUEST);
        }
        else if(getUserEmail != null){
            return new ResponseEntity<>(new MessageDTO("Email already exists"), HttpStatus.BAD_REQUEST);
        }
        else{
            try{
                userService.save(user);
                return new ResponseEntity<>(new MessageDTO("User registered"), HttpStatus.CREATED);
            }
            catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }



    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("/update/password")
    public ResponseEntity<?> updatePassword(@Valid UserPatchDTO user, BindingResult validations){

        if(validations.hasErrors()){
            return new ResponseEntity<>(
                    errorHandler.mapErrors(validations.getFieldErrors()),
                    HttpStatus.BAD_REQUEST
            );
        }

        try{
            userService.updatePassword(user.getPassword(), user.getId());
            return new ResponseEntity<>(new MessageDTO("Password updated"), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{value}")
    public ResponseEntity<?> deleteByUsernameOrEmail(@PathVariable(name = "value") String value){
        try{
            userService.deleteByUsernameOrEmail(value);
            return new ResponseEntity<>(new MessageDTO("User deleted"), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
