package com.games.Games.repositories;

import com.games.Games.models.BestOfTheYear;
import com.games.Games.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BestOfTheYearRepository extends JpaRepository<BestOfTheYear, UUID> {
}
