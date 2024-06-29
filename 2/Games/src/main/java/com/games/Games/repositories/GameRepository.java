package com.games.Games.repositories;

import com.games.Games.models.Game;
import com.games.Games.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
}
