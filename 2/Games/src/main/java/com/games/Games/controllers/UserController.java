package com.games.Games.controllers;


import com.games.Games.dtos.UserRecordDto;
import com.games.Games.models.User;
import com.games.Games.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("create")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRecordDto userRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userRecordDto));
    }

    /*@GetMapping
    public ResponseEntity getAllusers(){
        var allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }*/

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User has been deleted!");
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }
}
