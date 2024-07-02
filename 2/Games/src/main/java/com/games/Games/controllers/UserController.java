package com.games.Games.controllers;


import com.games.Games.dtos.UserRecordDto;
import com.games.Games.models.User;
import com.games.Games.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userRecordDto));
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted!");
    }
}
