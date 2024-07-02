package com.games.Games.services;


import com.games.Games.dtos.GameRecordDto;
import com.games.Games.models.Game;
import com.games.Games.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    @Transactional
    public void deleteUser(UUID id){
        gameRepository.deleteById(id);
    }

    @Transactional
    public Game saveGame(GameRecordDto gameRecordDto){
        Game game = new Game();
        game.setTitle(gameRecordDto.title());
        game.setPublisher(gameRecordDto.publisher());

        return gameRepository.save(game);
    }
}
