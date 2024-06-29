package com.games.Games.repositories;

import com.games.Games.models.Review;
import com.games.Games.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
}
