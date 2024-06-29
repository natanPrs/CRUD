package com.games.Games.repositories;

import com.games.Games.models.Account;
import com.games.Games.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
