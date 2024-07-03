package com.games.Games.services;

import com.games.Games.dtos.BestOfTheYearRecordDto;
import com.games.Games.models.BestOfTheYear;
import com.games.Games.repositories.BestOfTheYearRepository;
import com.games.Games.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BestOfTheYearService {
    private final GameRepository gameRepository;
    private final BestOfTheYearRepository bestOfTheYearRepository;

    public BestOfTheYearService(GameRepository gameRepository, BestOfTheYearRepository bestOfTheYearRepository) {
        this.gameRepository = gameRepository;
        this.bestOfTheYearRepository = bestOfTheYearRepository;
    }

    public List<BestOfTheYear> GetBestsOfTheYear(){
        return bestOfTheYearRepository.findAll();
    }

    @Transactional
    public void deleteBestOfTheYear(UUID id){
        bestOfTheYearRepository.deleteById(id);
    }

    @Transactional
    public BestOfTheYear saveBestOfTheYear(BestOfTheYearRecordDto bestOfTheYearRecordDto){
        BestOfTheYear bestOfTheYear = new BestOfTheYear();
        bestOfTheYear.setGame(gameRepository.findById(bestOfTheYearRecordDto.game()).get());
        bestOfTheYear.setYear(bestOfTheYearRecordDto.year());

        return bestOfTheYearRepository.save(bestOfTheYear);
    }
}
