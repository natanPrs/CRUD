package com.games.Games.repositories;

import com.games.Games.models.User;
import com.games.Games.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
