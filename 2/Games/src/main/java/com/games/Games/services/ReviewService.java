package com.games.Games.services;


import com.games.Games.dtos.ReviewRecordDto;
import com.games.Games.models.Review;
import com.games.Games.repositories.GameRepository;
import com.games.Games.repositories.ReviewRepository;
import com.games.Games.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final GameRepository gameRepository;

    public ReviewService(UserRepository userRepository, ReviewRepository reviewRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.gameRepository = gameRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    @Transactional
    public void deleteReview(UUID id){
        reviewRepository.deleteById(id);
    }

    @Transactional
    public Review saveReview(ReviewRecordDto reviewRecordDto){
        Review review = new Review();

        if (reviewRecordDto.rating() < 0 || reviewRecordDto.rating() > 10) {
            throw new IllegalArgumentException("Rating must be between 0 and 10");
        }

        review.setUser(userRepository.findById(reviewRecordDto.user()).get());
        review.setGame(gameRepository.findById(reviewRecordDto.game()).get());
        review.setTitle(reviewRecordDto.title());
        review.setRating(reviewRecordDto.rating());
        review.setDescription(reviewRecordDto.description());

        return reviewRepository.save(review);
    }
}
