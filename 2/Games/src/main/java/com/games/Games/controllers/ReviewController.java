package com.games.Games.controllers;

import com.games.Games.dtos.ReviewRecordDto;
import com.games.Games.models.Review;
import com.games.Games.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody ReviewRecordDto reviewRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.saveReview(reviewRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviews());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable UUID id){
        reviewService.deleteReview(id);
        return ResponseEntity.status(HttpStatus.OK).body("The review has been deleted!");
    }
}
