package com.games.Games.controllers;


import com.games.Games.dtos.GameRecordDto;
import com.games.Games.models.Game;
import com.games.Games.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody GameRecordDto gameRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(gameService.saveGame(gameRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.status(HttpStatus.OK).body(gameService.getAllGames());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable UUID id){
        gameService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("The game has been deleted!");
    }
}
