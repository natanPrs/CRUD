package com.games.Games.controllers;


import com.games.Games.dtos.BestOfTheYearRecordDto;
import com.games.Games.models.BestOfTheYear;
import com.games.Games.services.BestOfTheYearService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/BestsOfTheYear")
public class BestOfTheYearController {
    private final BestOfTheYearService bestOfTheYearService;

    public BestOfTheYearController(BestOfTheYearService bestOfTheYearService) {
        this.bestOfTheYearService = bestOfTheYearService;
    }

    @GetMapping
    public ResponseEntity<List<BestOfTheYear>> getBestsOfTheYear(){
        return ResponseEntity.status(HttpStatus.OK).body(bestOfTheYearService.GetBestsOfTheYear());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBestOfTheYear(@PathVariable UUID id){
        bestOfTheYearService.deleteBestOfTheYear(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");
    }

    @PostMapping
    public ResponseEntity<BestOfTheYear> saveBestOfTheYear(@RequestBody BestOfTheYearRecordDto bestOfTheYearRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bestOfTheYearService.saveBestOfTheYear(bestOfTheYearRecordDto));
    }
}
