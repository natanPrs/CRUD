package com.games.Games.dtos;

import com.games.Games.models.Account;
import com.games.Games.models.Game;
import com.games.Games.models.Review;

import java.util.Set;
import java.util.UUID;

public record UserRecordDto(String name,
                            Account account,
                            Set<UUID> games,
                            Set<UUID> wishlist) {
}